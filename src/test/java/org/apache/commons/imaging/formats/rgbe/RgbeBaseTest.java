/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.rgbe;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Sanselan;
import org.apache.commons.imaging.SanselanTest;

public abstract class RgbeBaseTest extends SanselanTest {
    private static boolean isRgbe( File file ) throws IOException,
                                                     ImageReadException
    {
        ImageFormat format = Sanselan.guessFormat( file );
        return format == ImageFormat.IMAGE_FORMAT_RGBE;
    }

    private static final ImageFilter IMAGE_FILTER = RgbeBaseTest::isRgbe;

    protected List getRgbeImages() throws IOException, ImageReadException {
        return getTestImages( IMAGE_FILTER );
    }
}