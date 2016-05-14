package javatar.service;

import javatar.model.AllegroCategories;
import javatar.model.Autopart;
import javatar.model.AutopartAllegroListModel;
import javatar.model.AutopartCategory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CreateAllegroLinkTest {
//    CreateAllegroLink createAllegroLink = new CreateAllegroLink();
//    AutopartAllegroListModel autopartAllegroListModel = null;
//    XMLParser xmlParser = null;
//
//    @BeforeClass
//    public static void initialize() throws IOException {
//        XMLParser xmlParser = null;
//        AutopartAllegroListModel autopartAllegroListModel = null;
//        InputStream fileReader = new FileInputStream("src/main/resources/Allegro_cathegories_2016-02-13.xml");
//        List<AllegroCategories> allegroCategoriesList = xmlParser.allegroCategoryObject(fileReader);
//        autopartAllegroListModel.setAllegroCategories(allegroCategoriesList);
//
//    }
//
//
//    @Test
//    public void test_create_allegro_link() throws Exception {
//        InputStream fileReader = new FileInputStream("resources/Allegro_cathegories_2016-02-13.xml");
//        List<AllegroCategories> allegroCategoriesList = xmlParser.allegroCategoryObject(fileReader);
//        autopartAllegroListModel.setAllegroCategories(allegroCategoriesList);
//
//        Autopart autopart = new Autopart();
//        AutopartCategory categoryListElement = new AutopartCategory();
//        categoryListElement.setName("Układ chłodzenia");
//        autopart.addCategoryToList(categoryListElement);
//        autopartAllegroListModel.setAutopart(autopart);
//
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-chlodzenie-silnika-18689")));
//
//    }
//
//    @Test
//    public void test_create_allegro_link_no_subcategory() throws Exception {
//        Autopart autopart = new Autopart();
//        AutopartCategory categoryListElement = new AutopartCategory();
//        categoryListElement.setName("Dwużlad");
//        autopart.addCategoryToList(categoryListElement);
//        autopartAllegroListModel.setAutopart(autopart);
//
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-620")));
//
//    }
//
//    @Test
//    public void test_create_allegro_link_chlodnice() throws Exception {
//        Autopart autopart = new Autopart();
//        AutopartCategory categoryListElement = new AutopartCategory();
//        categoryListElement.setName("Chłodzenie silnika");
//        autopart.addCategoryToList(categoryListElement);
//        AutopartCategory categoryListElement2 = new AutopartCategory();
//        categoryListElement2.setName("Chłodnice");
//        autopart.addCategoryToList(categoryListElement2);
//        AutopartCategory categoryListElement3 = new AutopartCategory();
//        categoryListElement3.setName("Chłodnice oleju");
//        autopart.addCategoryToList(categoryListElement3);
//        autopartAllegroListModel.setAutopart(autopart);
//
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/chlodnice-chlodnice-oleju-251083")));
//
//    }
//
//    @Test
//    public void test_match_2_categories() throws Exception {
//
//        //given
//        Autopart autopart = new Autopart();
//        AutopartCategory categoryListElement = new AutopartCategory();
//        categoryListElement.setName("Części karoserii");
//        autopart.addCategoryToList(categoryListElement);
//        AutopartCategory categoryListElement2 = new AutopartCategory();
//        categoryListElement2.setName("Maski");
//        autopart.addCategoryToList(categoryListElement2);
//        autopartAllegroListModel.setAutopart(autopart);
//
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-czesci-karoserii-4094")));
//    }
//
//    @Test
//    public void test_does_not_match_any_category() throws Exception {
//
//        //given
//        Autopart autopart = new Autopart();
//
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-620")));
//    }
//
//    @Test
//    public void test_matching_category_from_HashMap() {
//        Autopart autopart = new Autopart();
//        AutopartCategory categoryListElement = new AutopartCategory();
//        categoryListElement.setName("Układ chłodzenia");
//        autopart.addCategoryToList(categoryListElement);
//        AutopartCategory categoryListElement2 = new AutopartCategory();
//        categoryListElement2.setName("Chłodnice");
//        autopart.addCategoryToList(categoryListElement2);
//        autopartAllegroListModel.setAutopart(autopart);
//
//        //when
//        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);
//
//        assertThat(link,is(equalTo("http://allegro.pl/chlodzenie-silnika-chlodnice-18690")));
//
//    }

}