package com.zipcodewilmington.froilansfarm.Week_Tests;

import Animal.Chicken;
import Animal.Horse;
import Crop.Cornstalk;
import Crop.Crop;
import Crop.CropRow;
import Crop.TomatoPlant;
import FarmVehicle.CropDuster;
import FarmVehicle.Tractor;
import Food.*;
import Person.Farmer;
import Person.Pilot;
import Shelter.FarmHouse;
import Shelter.Stable;
import org.junit.Assert;
import org.junit.Test;
import Crop.Field;

public class Reference_Tests {
    @Test
    public void rideHorseTest2() {
        Farmer froilan = new Farmer("Froilan");

        Stable stable1 = new Stable();

        Horse horsey = new Horse();
        Horse fred = new Horse();
        Horse eugene = new Horse();

        stable1.add(horsey);
        stable1.add(fred);
        stable1.add(eugene);

        //if all horses are ridden, ridden value is true
        froilan.mount(horsey);
        froilan.dismount();
        froilan.mount(fred);
        froilan.dismount();
        froilan.mount(eugene);

        Boolean actual = eugene.isRidden();
        Assert.assertTrue(actual);
    }
        @Test
    public void rideHorseTest() {
        Farmer froilan = new Farmer("Froilan");
        Farmer froilanda = new Farmer("Froilanda");

        FarmHouse fh = new FarmHouse();
        fh.add(froilan);
        fh.add(froilanda);

        Stable stable1 = new Stable();
        Stable stable2 = new Stable();
        Stable stable3 = new Stable();

        Horse horsey = new Horse();
        Horse fred = new Horse();
        Horse eugene = new Horse();
        Horse brownie = new Horse();
        Horse bob = new Horse();
        Horse gertrude = new Horse();
        Horse apple = new Horse();
        Horse seven = new Horse(); //8
        Horse henry = new Horse();
        Horse caroline = new Horse();

        stable1.add(horsey);
        stable1.add(fred);
        stable1.add(eugene);

        stable2.add(brownie);
        stable2.add(bob);
        stable2.add(gertrude);

        stable3.add(apple);
        stable3.add(seven);
        stable3.add(henry);
        stable3.add(caroline);

        for(Horse horse : stable1) {
//            horse.setRidden(froilan);
            froilan.mount(horse);
            froilan.dismount();
        }

        for(Horse horse : stable2) {
//            horse.setRidden(froilanda);
            froilanda.mount(horse);
            froilanda.dismount();
        }

        for(Horse horse : stable3) {
//            horse.setRidden(froilan);
            froilan.mount(horse);
            froilan.dismount();
        }

        boolean allIsRidden = true;

        for(Horse horse : stable1) {
            if(horse.isRidden() == false) {
                allIsRidden = false;
            }
        }

        for(Horse horse : stable2) {
            if(horse.isRidden() == false) {
                allIsRidden = false;
            }
        }

        for(Horse horse : stable3) {
            if(horse.isRidden() == false) {
                allIsRidden = false;
            }
        }

        Assert.assertTrue(allIsRidden);
    }

    @Test
    public void feedHorsesTest() {
        //GET CORN
        //TODO - arraylist of cornstalk called CropRow
        //TODO - arraylist basket.add(froiland in tractor.harvest
        //TODO -    cornstalk, returning corn obj stored into basket

        //FEED HORSES
        //TODO - iterate through each stable(123), .remove(corn x3)
    }
    //He - 1 corn, 2 tomato, 5 egg
    //She - 2, 1, 2
    //total - 3, 3, 7
    public void feedpeople() {
        //TODO - create people
        //TODO - total food fields?  totalCorn = 3;
        //TODO - froilan.eat(corn);
        //TODO - create hashmap basket (Corn, CornArrayList)
        //TODO - Foodcrate, baskets

    }
    @Test
    public void fertilizeTest() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        Cornstalk cornstalk = new Cornstalk();
        // Pilot does not have to ride Cropduster
        cropDuster.fertilize(cornstalk);
        boolean actual = cornstalk.getFertilized();
        Assert.assertTrue(actual);
    }
    @Test
    public void fertilizeTest2() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        TomatoPlant tomatoPlant = new TomatoPlant();
        cropDuster.fertilize(tomatoPlant);
        boolean actual = tomatoPlant.getFertilized();
        Assert.assertTrue(actual);
    }
    @Test
    public void cropDusterRiddenTest() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        pilot.mount(cropDuster);
        boolean actual = cropDuster.isRidden();
        Assert.assertTrue(actual);
    }
    @Test
    public void cropDusterRiddenTest2() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        Cornstalk cornstalk = new Cornstalk();
        pilot.mount(cropDuster);
        cropDuster.fertilize(cornstalk);
        boolean actual = cornstalk.getFertilized();
        Assert.assertTrue(actual);
    }

    @Test
    public void harvestCropFlagTest(){
        Farmer farmer = new Farmer("Froilan");
        Tractor tractor = new Tractor();
        CropRow croprow = new CropRow();
        Cornstalk cornstalk1 = new Cornstalk();
        Cornstalk cornstalk2 = new Cornstalk();
        Cornstalk cornstalk3 = new Cornstalk();
        CornBasket cb = new CornBasket();
        croprow.add(cornstalk1);
        croprow.add(cornstalk2);
        croprow.add(cornstalk3);
        farmer.mount(tractor);
        /*for (Crop cs : croprow) {
            tractor.harvest(cs);
        }*/
        tractor.harvest(cornstalk1);
        Boolean actual = cornstalk1.getHarvested();
        Assert.assertTrue(actual);
    }

    @Test
    public void harvestCropTest(){
        Farmer farmer = new Farmer("Froilan");
        Tractor tractor = new Tractor();
        Cornstalk cornstalk = new Cornstalk();
        CornBasket cb = new CornBasket();
        farmer.mount(tractor);
        cb.add((Corn) tractor.harvest(cornstalk));
        int actual = cb.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void cropDusterFertilizeTest() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        Cornstalk cornstalk = new Cornstalk();
        pilot.mount(cropDuster);
        cropDuster.fertilize(cornstalk);
        boolean actual = cornstalk.getFertilized();
        Assert.assertTrue(actual);
    }

    @Test
    public void cropDusterFlyTest() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        Cornstalk cornstalk = new Cornstalk();
        pilot.mount(cropDuster);
        cropDuster.fertilize(cornstalk);
        boolean actual = cornstalk.getFertilized();
        Assert.assertTrue(actual);
//        On Monday, his sister, Froilanda uses the CropDuster to fly over the Field and fertilize each of the CropRow

    }

    @Test
    public void cropDusterFlyTest_checkFly() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        pilot.mount(cropDuster);
        boolean actual = cropDuster.getFly();
        Assert.assertTrue(actual);

    }

    @Test
    public void cropDusterFlyTest_checkLandPlane() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();
        pilot.mount(cropDuster);
        cropDuster.landPlane(); //needs to happen!!
        boolean actual = cropDuster.getFly();
        Assert.assertFalse(actual);

    }

    @Test
    public void fieldAndCropRowTest() {
        Field field = new Field();
        CropRow cornRow = new CropRow();
        CropRow tomatoRow = new CropRow();
        field.add(cornRow);
        field.add(tomatoRow);
        Cornstalk cornstalk1 = new Cornstalk();
        Cornstalk cornstalk2 = new Cornstalk();
        Cornstalk cornstalk3 = new Cornstalk();
        cornRow.add(cornstalk1);
        cornRow.add(cornstalk2);
        cornRow.add(cornstalk3);

        int expected = 2;
        int actual = field.size();
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void fieldAndCropRowTest_CropRowSize() {
        Field field = new Field();
        CropRow cornRow = new CropRow();
        CropRow tomatoRow = new CropRow();
        field.add(cornRow);
        field.add(tomatoRow);
        Cornstalk cornstalk1 = new Cornstalk();
        Cornstalk cornstalk2 = new Cornstalk();
        Cornstalk cornstalk3 = new Cornstalk();
        cornRow.add(cornstalk1);
        cornRow.add(cornstalk2);
        cornRow.add(cornstalk3);

        CropRow getCornField = (CropRow) field.get(0);
        int expected = 3;
        int actual = getCornField.size();
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void fieldAndCropRowTest_TomatoRowSize() {
        Field field = new Field();
        CropRow cornRow = new CropRow();
        CropRow tomatoRow = new CropRow();
        field.add(cornRow);
        field.add(tomatoRow);
        Cornstalk cornstalk1 = new Cornstalk();
        Cornstalk cornstalk2 = new Cornstalk();
        Cornstalk cornstalk3 = new Cornstalk();
        cornRow.add(cornstalk1);
        cornRow.add(cornstalk2);
        cornRow.add(cornstalk3);

        CropRow getTomatoRow = (CropRow) field.get(1);
        int expected = 0;
        int actual = getTomatoRow.size();
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void fertilizeCropRowsInField_Test() {
        Pilot pilot = new Pilot("Froilanda");
        CropDuster cropDuster = new CropDuster();

        Field field = new Field();
        CropRow cornRow = new CropRow();
        CropRow tomatoRow = new CropRow();
        field.add(cornRow);
        field.add(tomatoRow);
        Cornstalk cornstalk1 = new Cornstalk();
        Cornstalk cornstalk2 = new Cornstalk();
        Cornstalk cornstalk3 = new Cornstalk();
        cornRow.add(cornstalk1);
        cornRow.add(cornstalk2);
        cornRow.add(cornstalk3);

        pilot.mount(cropDuster);

        //pilot flies over the field
        //fertilizes each crop of the cropRow in the field

        for (int i = 0; i < field.size(); i++) {
            CropRow cropRowTemp = (CropRow) field.get(i);
            for (int j = 0; j < cropRowTemp.size(); j++) {
                Crop cropTemp = (Crop) cropRowTemp.get(j);
                cropDuster.fertilize(cropTemp);
            }
        }

        boolean allIsFertilized = true;

        for (int i = 0; i < field.size(); i++) {
            CropRow cropRowTemp = (CropRow) field.get(i);
            for (int j = 0; j < cropRowTemp.size(); j++) {
                Crop cropTemp = (Crop) cropRowTemp.get(j);
                if (cropTemp.getFertilized() == false) {
                    allIsFertilized = false;
                    break;
                }
            }
        }


        Assert.assertTrue(allIsFertilized);

    }

    @Test
    public void botanistTest() {
        Farmer froilan = new Farmer();
        CropRow cr = new CropRow();
        Crop crop = new Crop();
        froilan.plantCrop(cr, crop);
        int actual = cr.size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void cornStalkBotanistTest() {
        Farmer froilan = new Farmer();
        CropRow cr = new CropRow();
        Cornstalk cs1 = new Cornstalk();
        Cornstalk cs2 = new Cornstalk();
        froilan.plantCrop(cr, cs1);
        froilan.plantCrop(cr, cs2);
        int actual = cr.size();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void fertilizeChickenAndStoreTest() {
        Chicken chick = new Chicken();
        EggBasket eggBask = new EggBasket();
        chick.fertilized();
        eggBask.add((Egg) chick.yield());
        int actual = eggBask.size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void chickenFertilizedTest() {
        Chicken chick = new Chicken();
        chick.fertilized();
        boolean actual = chick.getFertilized();
        Assert.assertTrue(actual);
    }
    @Test
    public void eggNotFertilizedTest() {
        Chicken chick = new Chicken();
        Egg egg = (Egg) chick.yield();
        boolean actual = egg.isEdible();
        Assert.assertFalse(actual);
    }
    @Test
    public void eggFertilizedTest() {
        Chicken chick = new Chicken();
        chick.fertilized();
        Egg egg = (Egg) chick.yield();
        boolean actual = egg.isEdible();
        Assert.assertTrue(actual);
    }

    @Test
    public void animalEatingTest(){
        Horse helga = new Horse("helga");
        TomatoBasket tb = new TomatoBasket();
        Tomato tamota = new Tomato();
        Tomato tamata = new Tomato();
        Tomato tomoto = new Tomato();
        tb.add(tamota);
        tb.add(tamata);
        tb.add(tomoto);
        int amountToEat = 2;
        helga.eat(tb, amountToEat);
        int actual = tb.size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void personEatingTest(){
        Farmer froy = new Farmer();
        Chicken chip = new Chicken();
        chip.fertilized();
        EggBasket eb = new EggBasket();
        Egg egg1 = (Egg) chip.yield();
        eb.add(egg1);
        int amountToEat = 1;
        froy.eat(eb, amountToEat);
        int actual = eb.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void animalFedFlagTest(){
        Horse helga = new Horse("helga");
        TomatoBasket tb = new TomatoBasket();
        Tomato tamota = new Tomato();
        Tomato tamata = new Tomato();
        Tomato tomoto = new Tomato();
        tb.add(tamota);
        tb.add(tamata);
        tb.add(tomoto);
        int amountToEat = 2;
        helga.eat(tb, amountToEat);
        Boolean actual = helga.isFed();
        Assert.assertTrue(actual);
    }

    @Test
    public void personFedFlagTest(){
        Farmer froy = new Farmer();
        Chicken chip = new Chicken();
        chip.fertilized();
        EggBasket eb = new EggBasket();
        Egg egg1 = (Egg) chip.yield();
        eb.add(egg1);
        int amountToEat = 1;
        froy.eat(eb, amountToEat);
        Boolean actual = froy.isFed();
        Assert.assertTrue(actual);
    }
}
