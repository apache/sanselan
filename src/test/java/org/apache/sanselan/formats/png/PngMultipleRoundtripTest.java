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

package org.apache.sanselan.formats.png;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.sanselan.ImageFormat;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.util.Debug;

public class PngMultipleRoundtripTest extends PngBaseTest
{

	public void test() throws IOException, ImageReadException,
			ImageWriteException
	{
		File imagesFolder = new File("src\\test\\data\\images\\png\\3");
		assertTrue(imagesFolder.exists() && imagesFolder.isDirectory());
		
		File files[] = imagesFolder.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			File imageFile = files[i];
			if(!imageFile.isFile() )
				continue;
			if(!imageFile.getName().toLowerCase().endsWith(".png"))
				continue;
			
			Debug.debug();
			Debug.debug("imageFile", imageFile);

			File lastFile = imageFile;
			for (int j = 0; j < 10; j++)
			{
				Map readParams = new HashMap();
				// readParams.put(SanselanConstants.BUFFERED_IMAGE_FACTORY,
				// new RgbBufferedImageFactory());
				BufferedImage image = Sanselan.getBufferedImage(lastFile,
						readParams);
				assertNotNull(image);

				File tempFile = createTempFile(imageFile.getName() + "." + j
						+ ".", ".png");
				Debug.debug("tempFile", tempFile);

				Map writeParams = new HashMap();
				Sanselan.writeImage(image, tempFile,
						ImageFormat.IMAGE_FORMAT_PNG, writeParams);

				lastFile = tempFile;
			}
		}
	}

}
