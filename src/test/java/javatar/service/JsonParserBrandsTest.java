package javatar.service;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JsonParserBrandsTest {

    @Test
    public void should_find_opel() throws FileNotFoundException {
        String searchToken = "opel";
        JsonParserBrands jsonParserList = new JsonParserBrands();


        try {
            String searchTest = jsonParserList.searchCarId(searchToken);
            assertThat(searchTest, is(equalTo("fy")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}