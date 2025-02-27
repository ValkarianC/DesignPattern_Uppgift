package org.example.Controller;

import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.Model.Garments.Trousers.Trousers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrouserBuilderTest {
    private TrouserBuilder trouserBuilder = new TrouserBuilder();

    @Test
    public void testBuildWithoutParameters(){
        assertThrows(BuildException.class, trouserBuilder::build);
    }



    @Test
    public void testBuildWithMissingSize(){
        trouserBuilder.setMaterial(GarmentMaterial.Wool).setFit(TrouserFit.Flared).setLength(TrouserLength.Long).setColour(GarmentColour.Red);
        BuildException exception = assertThrows(BuildException.class, trouserBuilder::build);
        assertTrue(exception.getMessage().contains("creation"));
    }

    @Test
    public void testBuildWithMissingMaterial(){
        trouserBuilder.setSize(GarmentSize.Large).setColour(GarmentColour.Red).setFit(TrouserFit.Flared).setLength(TrouserLength.Long);
        BuildException exception = assertThrows(BuildException.class, trouserBuilder::build);
        assertTrue(exception.getMessage().contains("creation"));
    }

    @Test
    public void testBuildWithMissingColour(){
        trouserBuilder.setSize(GarmentSize.Large).setMaterial(GarmentMaterial.Wool).setFit(TrouserFit.Flared).setLength(TrouserLength.Long);
        BuildException exception = assertThrows(BuildException.class, trouserBuilder::build);
        assertTrue(exception.getMessage().contains("creation"));
    }

    @Test
    public void testBuildWithMissingFit(){
        trouserBuilder.setSize(GarmentSize.Large).setMaterial(GarmentMaterial.Wool).setColour(GarmentColour.Red).setLength(TrouserLength.Long);
        BuildException exception = assertThrows(BuildException.class, trouserBuilder::build);
        assertTrue(exception.getMessage().contains("creation"));
    }

    @Test
    public void testBuildWithMissingLength(){
        trouserBuilder.setSize(GarmentSize.Large).setMaterial(GarmentMaterial.Wool).setColour(GarmentColour.Red).setFit(TrouserFit.Flared);
        BuildException exception = assertThrows(BuildException.class, trouserBuilder::build);
        assertTrue(exception.getMessage().contains("creation"));
    }


    //Test individual values with null as given value
    @Test
    public void testSizeWithNullValue(){
        BuildException exception = assertThrows(BuildException.class,()->trouserBuilder.setSize(null));
        assertTrue(exception.getMessage().contains("Size"));
    }
    @Test
    public void testMaterialWithNullValue(){
        BuildException exception = assertThrows(BuildException.class,()->trouserBuilder.setMaterial(null));
        assertTrue(exception.getMessage().contains("Material"));
    }
    @Test
    public void testColourWithNullValue(){
        BuildException exception = assertThrows(BuildException.class,()->trouserBuilder.setColour(null));
        assertTrue(exception.getMessage().contains("Colour"));
    }
    @Test
    public void testFitWithNullValue(){
        BuildException exception = assertThrows(BuildException.class,()->trouserBuilder.setFit(null));
        assertTrue(exception.getMessage().contains("Fit"));
    }
    @Test
    public void testLengthWithNullValue(){
        BuildException exception = assertThrows(BuildException.class,()->trouserBuilder.setLength(null));
        assertTrue(exception.getMessage().contains("Length"));
    }

    @Test
    public void testValidBuildShouldWork(){
        trouserBuilder.setSize(GarmentSize.Large).setMaterial(GarmentMaterial.Wool).setColour(GarmentColour.Red).setFit(TrouserFit.Flared).setLength(TrouserLength.Long);
        Trousers testTrousers = trouserBuilder.build();
        assertEquals("Large", testTrousers.getSize().toString());
        assertEquals("Wool", testTrousers.getMaterial().toString());
        assertEquals("Red", testTrousers.getColour().toString());
        assertEquals("Flared", testTrousers.getFit().toString());
        assertEquals("Long", testTrousers.getLength().toString());
    }

}