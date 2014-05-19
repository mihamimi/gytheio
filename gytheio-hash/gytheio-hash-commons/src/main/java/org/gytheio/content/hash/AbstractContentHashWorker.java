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
package org.gytheio.content.hash;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gytheio.content.AbstractContentWorker;
import org.gytheio.content.ContentReference;

/**
 * Abstract hash node worker which uses a content reference handler to convert the 
 * content reference into a usable input stream for the actual implementation.
 * 
 * @author Ray Gauss II
 */
public abstract class AbstractContentHashWorker extends AbstractContentWorker implements ContentHashWorker
{

    @Override
    public void initialize()
    {
    }
    
    @Override
    public Map<ContentReference, String> generateHashes(
            List<ContentReference> sources, 
            String hashAlgorithm) throws Exception
    {
        Map<ContentReference, String> values = new HashMap<ContentReference, String>();
        if (sources == null || sources.size() == 0)
        {
            return values;
        }
        for (ContentReference source : sources)
        {
            String value = generateHashInternal(
                    sourceContentReferenceHandler.getInputStream(source, true),
                    hashAlgorithm);
            values.put(source, value);
        }
        return values;
    }
    
    /**
     * Computes the hash value for the given input stream using the given algorithm
     * 
     * @param sourceFile
     * @param hashAlgorithm
     * @return the hex encoded hash value
     * @throws Exception
     */
    public abstract String generateHashInternal(
            InputStream sourceFile,
            String hashAlgorithm) throws Exception;
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(this.getClass().getSimpleName() + "[");
        builder.append("contentReferenceHandler: " + sourceContentReferenceHandler.toString());
        builder.append("]");
        return builder.toString();
    }

}