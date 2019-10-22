package com.manchesterdigital.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeatureHandlerTest {

    private FeatureHandler featureHandler;
    private static Feature featureOne = new Feature("one", false);
    private static Feature featureTwo = new Feature("two", false);
    private static Feature featureThree = new Feature("three", true);

    @Test
    public void aNewFeatureIsAddedCorrectly() {
        givenANewFeatureHandler();
        whenAFeatureIsAdded(featureOne);
        thenShouldContainAFeature(featureOne);
        thenFeatureMapShouldNotBeEmpty();
    }

    @Test
    void aSecondNewFeatureIsAddedCorrectly() {
        givenANewFeatureHandler();
        whenAFeatureIsAdded(featureOne);
        whenAFeatureIsAdded(featureTwo);
        thenShouldContainAFeature(featureOne);
        thenShouldContainAFeature(featureTwo);
        thenFeatureMapShouldNotBeEmpty();
    }

    @Test
    void aTwoOfTheSameFeatureWillNotAddToMapMoreThanOnce() {
        givenANewFeatureHandler();
        whenAFeatureIsAdded(featureOne);
        whenAFeatureIsAdded(featureOne);
        thenShouldContainAFeature(featureOne);
        thenFeatureMapShouldNotBeEmpty();
        thenFeatureMapShouldBeSize(1);
    }

    @Test
    void addFeatures_aNewFeatureWithValueFalseHasValueUpdatedToTrueUsingSetIsEnabled() {
        givenANewFeatureHandler();
        whenAFeatureIsAddedWithValueFalse(featureOne);
        whenAFeatureValueIsUpdatedToTrue(featureOne);
        thenFeatureMapShouldNotBeEmpty();
        thenFeatureValueShouldBeUpdatedToTrue(featureOne);
    }

    @Test
    void addFeatures_aNewFeatureValueUpdatedToFalseUsingSetIsEnabled() {
        givenANewFeatureHandler();
        whenAFeatureIsAddedWithValueTrue(featureThree);
        whenAFeatureValueIsUpdatedToFalse(featureThree);
        thenFeatureMapShouldNotBeEmpty();
        thenFeatureValueShouldBeUpdatedToFalse(featureThree);
    }

    public void givenANewFeatureHandler() {
        featureHandler = new FeatureHandler();
        assertTrue(featureHandler.getNewMap().isEmpty());
    }

    private void whenAFeatureIsAdded(Feature newFeature) {
        featureHandler.addFeatures(newFeature);
    }

    private void whenAFeatureIsAddedWithValueFalse(Feature newFeature) {
        featureHandler.addFeatures(newFeature);
    }

    private void whenAFeatureIsAddedWithValueTrue(Feature newFeature) {
        featureHandler.addFeatures(newFeature);
    }

    private void whenAFeatureValueIsUpdatedToTrue (Feature newFeature) {
        newFeature.setIsEnabled(true);
    }

    private void whenAFeatureValueIsUpdatedToFalse (Feature newFeature) {
        newFeature.setIsEnabled(false);
    }

    private void thenShouldContainAFeature (Feature featureToCheck){
        assertTrue(featureHandler.getNewMap().containsValue(featureToCheck));
    }

    private void thenFeatureMapShouldNotBeEmpty (){
        assertFalse(featureHandler.getNewMap().isEmpty());
    }

    private void thenFeatureMapShouldBeSize (int number){
        assertTrue(featureHandler.getNewMap().size() == number);
    }

    private void thenFeatureValueShouldBeUpdatedToTrue (Feature featureToCheck){
        assertTrue(featureToCheck.getIsEnabled().equals(true));
    }

    private void thenFeatureValueShouldBeUpdatedToFalse (Feature featureToCheck){
        assertTrue(featureToCheck.getIsEnabled().equals(false));
    }

}