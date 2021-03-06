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
package org.gytheio.health.heartbeat;

/**
 * Defines the object responsible for producing {@link Heartbeat}s
 * which let services monitor health of other services in the system.
 * 
 * @author Ray Gauss II
 */
public interface Heart
{
    /**
     * Starts the repeated sending of {@link Heartbeat} messages 
     * for health monitoring
     */
    public void start();
    
    /**
     * Stops the repeated sending of {@link Heartbeat} messages 
     * for health monitoring
     */
    public void stop();
    
    /**
     * Returns a single {@link Heartbeat} object without sending
     * via messaging
     * 
     * @return the heartbeat object
     */
    public Heartbeat beat();
    
}
