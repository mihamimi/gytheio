/*
 * Copyright (C) 2005-2013 Alfresco Software Limited.
 *
 * This file is part of an Alfresco messaging investigation
 *
 * The Alfresco messaging investigation is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Alfresco messaging investigation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Alfresco messaging investigation. If not, see <http://www.gnu.org/licenses/>.
 */
package org.gytheio.content.transform.ffmpeg;

import org.gytheio.content.handler.FileContentReferenceHandlerImpl;
import org.gytheio.content.transform.BaseContentTransformerNode;
import org.gytheio.messaging.amqp.AmqpDirectEndpoint;
import org.gytheio.messaging.amqp.AmqpNodeBootstrapUtils;

/**
 * Starts up an AMQP FFmpeg transformer node via command line arguments
 * 
 * @author Ray Gauss II
 */
public class FfmpegAmqpContentTransformerNodeBootstrap
{
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        AmqpNodeBootstrapUtils.validateArguments(args);
        
        FfmpegContentTransformerWorker worker = new FfmpegContentTransformerWorker();
        worker.setContentReferenceHandler(new FileContentReferenceHandlerImpl());
        worker.init();
        
        BaseContentTransformerNode node = new BaseContentTransformerNode();
        node.setWorker(worker);
        
        AmqpDirectEndpoint endpoint = AmqpNodeBootstrapUtils.createEndpoint(node, args);
        node.setMessageProducer(endpoint);
        
        endpoint.startListener();
    }
    
}