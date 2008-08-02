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

package org.apache.sanselan.formats.tiff;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sanselan.ImageFormat;
import org.apache.sanselan.ImageInfo;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.util.Debug;

public class TiffRoundtripTest extends TiffBaseTest
{

	public void test() throws IOException, ImageReadException,
			ImageWriteException
	{
		List images = getTiffImages();
		for (int i = 0; i < images.size(); i++)
		{
			if (i % 10 == 0)
				Debug.purgeMemory();

			File imageFile = (File) images.get(i);
			Debug.debug("imageFile", imageFile);

			IImageMetadata metadata = Sanselan.getMetadata(imageFile);
			assertNotNull(metadata);

			ImageInfo imageInfo = Sanselan.getImageInfo(imageFile);
			assertNotNull(imageInfo);

			BufferedImage image = Sanselan.getBufferedImage(imageFile);
			assertNotNull(image);

			File tempFile = createTempFile(imageFile.getName() + ".", ".tif");
			Map params = new HashMap();
			Sanselan.writeImage(image, tempFile,
					ImageFormat.IMAGE_FORMAT_TIFF, params);

			BufferedImage image2 = Sanselan.getBufferedImage(tempFile);
			assertNotNull(image2);
		}
	}

}
