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

package org.apache.sanselan.formats.gif;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.sanselan.ImageFormat;
import org.apache.sanselan.ImageInfo;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.SanselanTest;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.util.Debug;

public class GifReadTest extends GifBaseTest
{

	public void test() throws IOException, ImageReadException,
			ImageWriteException
	{
		Debug.debug("start");

		List images = getGifImages();
		for (int i = 0; i < images.size(); i++)
		{
			if (i % 10 == 0)
				Debug.purgeMemory();

			File imageFile = (File) images.get(i);
			Debug.debug("imageFile", imageFile);

			IImageMetadata metadata = Sanselan.getMetadata(imageFile);
//			assertNotNull(metadata);

			ImageInfo imageInfo = Sanselan.getImageInfo(imageFile);
			assertNotNull(imageInfo);

			BufferedImage image = Sanselan.getBufferedImage(imageFile);
			assertNotNull(image);
		}
	}

}
