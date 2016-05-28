package javatar.service;

import javatar.model.AllegroCategories;
import javatar.model.Autopart;
import javatar.model.AutopartAllegroListModel;
import javatar.model.AutopartCategory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CreateAllegroLinkTest {
    AllegroCategoryFinder allegroCategoryFinder = new AllegroCategoryFinder();
    CreateAllegroLink createAllegroLink = new CreateAllegroLink();
    AutopartAllegroListModel autopartAllegroListModel = new AutopartAllegroListModel();
    XMLParser xmlParser = new XMLParser();
    List<AllegroCategories> allegroCategoriesList = new ArrayList<>();

    @Before
    public void initialize() {
        InputStream allegroCategoriesFile = this.getClass().getResourceAsStream("/Allegro_cathegories_2016-02-13.xml");
        allegroCategoriesList = xmlParser.allegroCategoryObject(allegroCategoriesFile);
        autopartAllegroListModel.setAllegroCategories(allegroCategoriesList);
    }

    @Test
    public void test_create_allegro_link() throws Exception {
        Autopart autopart = new Autopart();
        AutopartCategory categoryListElement = new AutopartCategory();
        categoryListElement.setName("Układ chłodzenia");
        autopart.addCategoryToList(categoryListElement);
        autopartAllegroListModel.setAutopart(autopart);

        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-chlodzenie-silnika-18689")));

    }

    @Test
    public void test_create_allegro_link_no_subcategory() throws Exception {
        Autopart autopart = new Autopart();
        AutopartCategory categoryListElement = new AutopartCategory();
        categoryListElement.setName("Dwużlad");
        autopart.addCategoryToList(categoryListElement);
        autopartAllegroListModel.setAutopart(autopart);

        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-620")));

    }

    @Test
    public void test_create_allegro_link_chlodnice() throws Exception {
        Autopart autopart = new Autopart();
        AutopartCategory categoryListElement = new AutopartCategory();
        categoryListElement.setName("Chłodzenie silnika");
        autopart.addCategoryToList(categoryListElement);
        AutopartCategory categoryListElement2 = new AutopartCategory();
        categoryListElement2.setName("Chłodnice");
        autopart.addCategoryToList(categoryListElement2);
        AutopartCategory categoryListElement3 = new AutopartCategory();
        categoryListElement3.setName("Chłodnice oleju");
        autopart.addCategoryToList(categoryListElement3);
        autopartAllegroListModel.setAutopart(autopart);

        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/chlodnice-chlodnice-oleju-251083")));

    }

    @Test
    public void test_match_2_categories() throws Exception {

        //given
        Autopart autopart = new Autopart();
        AutopartCategory categoryListElement = new AutopartCategory();
        categoryListElement.setName("Części karoserii");
        autopart.addCategoryToList(categoryListElement);
        AutopartCategory categoryListElement2 = new AutopartCategory();
        categoryListElement2.setName("Maski");
        autopart.addCategoryToList(categoryListElement2);
        autopartAllegroListModel.setAutopart(autopart);

        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-czesci-karoserii-4094")));
    }

    @Test
    public void test_does_not_match_any_category() throws Exception {

        //given
        Autopart autopart = new Autopart();
        autopartAllegroListModel.setAutopart(autopart);

        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/czesci-samochodowe-620")));
    }

    @Test
    public void test_matching_category_from_HashMap() {
        Autopart autopart = new Autopart();
        AutopartCategory categoryListElement = new AutopartCategory();
        categoryListElement.setName("Układ chłodzenia");
        autopart.addCategoryToList(categoryListElement);
        AutopartCategory categoryListElement2 = new AutopartCategory();
        categoryListElement2.setName("Chłodnice");
        autopart.addCategoryToList(categoryListElement2);
        autopartAllegroListModel.setAutopart(autopart);

        //when
        String link = createAllegroLink.createAllegroLink(autopartAllegroListModel);

        assertThat(link,is(equalTo("http://allegro.pl/chlodzenie-silnika-chlodnice-18690")));

    }

}