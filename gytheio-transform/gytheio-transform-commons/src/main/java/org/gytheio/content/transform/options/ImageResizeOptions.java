/*
 * Copyright (C) 2005-2014 Alfresco Software Limited.
 *
 * This file is part of Gytheio
 *
 * Gytheio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Gytheio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Gytheio. If not, see <http://www.gnu.org/licenses/>.
 */
package org.gytheio.content.transform.options;

import java.io.Serializable;

import org.gytheio.util.BeanUtils;
import org.gytheio.util.ToStringProperty;

/**
 * Image resize options
 * 
 * @author Roy Wetherall
 */
public class ImageResizeOptions implements Serializable
{
    private static final long serialVersionUID = -6251308339825657974L;

    /** The width */
    private int width = -1;
    
    /** The height */
    private int height = -1;
    
    /** Indicates whether the aspect ratio of the image should be maintained */
    private boolean maintainAspectRatio = true;
    
    /** Indicates whether this is a percentage resize */
    private boolean percentResize = false;
    
    /** Indicates whether the resized image is a thumbnail */
    private boolean resizeToThumbnail = false;
    
    /**
     * Indicates that scaling operations should scale up or down to the specified dimensions, as requested.
     * If this argument is false, only resizings that scale the image down will be performed. Scaling up will result in
     * an unchanged image.
     * @since 4.0
     */
    private boolean allowEnlargement = true;
    
    /**
     * Default constructor
     */
    public ImageResizeOptions()
    {
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    @ToStringProperty
    public int getWidth()
    {
        return width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    @ToStringProperty
    public int getHeight()
    {
        return height;
    }
    
    public void setMaintainAspectRatio(boolean maintainAspectRatio)
    {
        this.maintainAspectRatio = maintainAspectRatio;
    }
    
    @ToStringProperty
    public boolean isMaintainAspectRatio()
    {
        return maintainAspectRatio;
    }
    
    public void setPercentResize(boolean percentResize)
    {
        this.percentResize = percentResize;
    }
    
    @ToStringProperty
    public boolean isPercentResize()
    {
        return percentResize;
    }
    
    public void setResizeToThumbnail(boolean resizeToThumbnail)
    {
        this.resizeToThumbnail = resizeToThumbnail;
    }
    
    @ToStringProperty
    public boolean isResizeToThumbnail()
    {
        return resizeToThumbnail;
    }    
    
    public void setAllowEnlargement(boolean allowEnlargement)
    {
        this.allowEnlargement = allowEnlargement;
    }
    
    @ToStringProperty
    public boolean getAllowEnlargement()
    {
        return allowEnlargement;
    }

    @Override
    public String toString()
    {
        return BeanUtils.toString(this);
    }
    
}
