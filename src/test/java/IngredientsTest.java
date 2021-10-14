import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngredientsTest {

    Ingredients ingredients;

    @Before
    public void setUp(){
        ingredients = new Ingredients("Egg", 10, 100);
    }

    @Test
    public void testGetIngredientsName(){
        assertEquals("Egg", ingredients.getIngredientsName());
    }

    public void testGetCalories(){
        assertEquals(1000, ingredients.getCalories());
    }

    public void testGetWeight(){
        assertEquals(100, ingredients.getWeight());
    }




}