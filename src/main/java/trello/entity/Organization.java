/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package trello.entity;

/**
 * Defines an Organization.
 *
 * @version 0.1 03 March 2020.
 *
 * @author Enrique Carrizales.
 */
public class Organization {

    // Content name value.
    private String name;

    // Content description value.
    private String description;

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
     * Gets description value.
     * @return description value.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description value.
     * @param description value.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
