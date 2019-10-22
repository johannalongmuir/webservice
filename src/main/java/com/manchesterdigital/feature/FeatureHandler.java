package com.manchesterdigital.feature;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class FeatureHandler {

    @Getter
    private Map<String, Feature> newMap = new HashMap<>();

    public void addFeatures (Feature newFeature) {
        newMap.put(newFeature.getName(), newFeature);
        ghjdfsa
        // not best way to do it but will update whole entry in Map and change boolean
        //newFeature.setIsEnabled(!newFeature.getIsEnabled()? true:false);

    }


}
