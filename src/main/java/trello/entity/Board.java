/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package trello.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a Board.
 *
 * @version 0.1 03 March 2020.
 *
 * @author Enrique Carrizales.
 */
public class Board {

    // Content name value.
    private String name;

    // Content organization value.
    private String organization;

    // Content visibility value.
    private String visibility;

    /**
     * Gets getName value.
     * @return filePath value.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name value.
     * @param name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets organization value.
     * @return organization value.
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets organization value.
     * @param organization value.
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Gets visibility value.
     * @return visibility value.
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Sets visibility value.
     * @param visibility value.
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }


    public void setBoardInformation(final Map<String, String> boardAttributes) {
        HashMap<String, Runnable> strategyMAp = composeStrategyMap(boardAttributes);
        boardAttributes.keySet().forEach(key -> strategyMAp.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(Map<String, String> boardAttributes) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put("name", () -> setName(boardAttributes.get("name")));
        strategyMap.put("visibility", () ->  setVisibility(boardAttributes.get("visibility")));

        return strategyMap;
    }
}
