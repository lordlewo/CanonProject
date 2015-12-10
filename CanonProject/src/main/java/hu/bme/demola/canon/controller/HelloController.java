package hu.bme.demola.canon.controller;

import hu.bme.demola.canon.component.imagedominantcolor.ImageDominantColorManager;
import hu.bme.demola.canon.component.imagemetadata.ImageMetadataManager;
import hu.bme.demola.canon.component.imagescaling.ImageScalingManager;
import hu.bme.demola.canon.entity.*;
import hu.bme.demola.canon.entity.dto.ImageDto;
import hu.bme.demola.canon.entity.dto.TagDto;
import hu.bme.demola.canon.entity.mappingmanager.MappingManager;
import hu.bme.demola.canon.repository.idao.ImageDao;
import hu.bme.demola.canon.repository.idao.TestRepo;
import hu.bme.demola.canon.service.iservice.CanonService;
import hu.bme.demola.canon.service.iservice.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private CanonService canonService;

    @Autowired
    private MappingManager mappingManager;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageDao imageDao;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TestRepo testRepository;

    @Autowired
    private ImageDominantColorManager imageDominantColorManager;

    @Autowired
    private ImageScalingManager imageScalingManager;

    @Autowired
    private ImageMetadataManager imageMetadataManager;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloMessage(Model model){

        logger.debug("dfsdfsfsfs");

        Test tt = new Test();
        tt.setName("sdfsdfadasd");
        testRepository.create(tt);

        testRepository.createTest();

        Image i = new Image();
        i.setHomeDirectory("sg");
        i.setName("adfsa");

        Metadata m = new Metadata();
        i.setMetadata(m);

        Mime mi = new Mime();
        mi.setMimeType("adf");
        mi.setName("sdf");
        mi.setSuffix("afad");
        i.setMime(mi);

        Album a = new Album();
        a.setDescription("adf");
        a.setName("sdfs");
        a.getImageList().add(i);

        Tag t = new Tag();
        t.setDescription("sdf");
        t.setName("sdfsfg");
        t.getImageList().add(i);

        i.getAlbumList().add(a);
        i.getTagList().add(t);

        //imageDao.create(i);

        List images = em.createNativeQuery("SELECT * FROM canon.image", Image.class).getResultList();

        model.addAttribute("message", "Hello from Controller!");
        model.addAttribute("images", images);
        try {
            model.addAttribute("col", imageDominantColorManager.getDominantColorInRGBString("D:/canon/images/skyrim.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "hello";

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){

        List tests = em.createNativeQuery("SELECT * FROM canon.test", Test.class).getResultList();
        model.addAttribute("tests", tests);
        return "test";

    }


    @RequestMapping(value = "/hellotest", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Test> helloTest(){

        return em.createNativeQuery("SELECT * FROM canon.test", Test.class).getResultList();
    }

    @RequestMapping(value = "/hellotestimage", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ImageDto helloTestImage(){

        Image image = imageService.findOneByIdWithAlbumsAndTags(Long.valueOf(1));

        ImageDto dto = mappingManager.mapImageForImage(image);


 /*       Image i = new Image();
        i.setHomedir("sg");
        i.setName("adfsa");

        Metadata m = new Metadata();
        i.setMetadata(m);

        Mime mi = new Mime();
        mi.setMimetype("adf");
        mi.setName("sdf");
        mi.setSuffix("afad");
        i.setMime(mi);

        Album a = new Album();
        a.setDescription("adf");
        a.setName("sdfs");
        a.getImageList().add(i);

        Tag t = new Tag();
        t.setDescription("sdf");
        t.setName("sdfsfg");
        t.getImageList().add(i);

        i.getAlbumList().add(a);
        i.getTagList().add(t);

        canonServiceManager.create(i);*/

        return mappingManager.mapImageForImage(image);
    }

    @RequestMapping(value = "/hellotestimages", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ImageDto> helloTestImages(){

        return canonService.getImages();
    }

    @RequestMapping(value = "/helloname", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TagDto> helloname(){

        return canonService.getImageTagsById(1l);
    }

    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImage() {
        File imageFile = new File( "D:/canon/images/skyrim.jpg" );
        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Object> m = imageMetadataManager.getExifDatas(imageFile);

        try {
            String rgbColor = imageDominantColorManager.getDominantColorInRGBHexString(imageFile);
            String rgbHexColor = imageDominantColorManager.getDominantColorInRGBString(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .contentLength( imageFile.length() )
                .contentType(MediaType.valueOf("image/jpg"))
                .body(new InputStreamResource(fileInputStream));
    }

    @RequestMapping(value = "/getImageThumb", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImageThumb() {

        File imageFile = new File("D:/canon/images/skyrim.jpg" );
        File thumbFile = new File("D:/canon/skyrimthumb.jpg");

        BufferedImage thumb = null;

        InputStream fileInputStream = null;

        try {
            thumb = imageScalingManager.createThumbnail(imageFile, 300);
            ImageIO.write(thumb, "jpg", thumbFile);
            fileInputStream = new FileInputStream(thumbFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentLength( imageFile.length() )
                .contentType(MediaType.valueOf("image/jpg"))
                .body(new InputStreamResource(fileInputStream));
    }


}
