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

package org.apache.sanselan.formats.jpeg;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.sanselan.ImageFormat;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.SanselanTest;
import org.apache.sanselan.common.byteSources.ByteSource;
import org.apache.sanselan.common.byteSources.ByteSourceArray;
import org.apache.sanselan.common.byteSources.ByteSourceFile;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata.Photoshop;
import org.apache.sanselan.formats.jpeg.exifRewrite.ExifRewriter;
import org.apache.sanselan.formats.tiff.TiffImageMetadata;
import org.apache.sanselan.util.Debug;
import org.apache.sanselan.util.IOUtils;

public class ExifRewriteTest extends ExifBaseTest
{
	public ExifRewriteTest(String name)
	{
		super(name);
	}

	public void testRemove() throws IOException, ImageReadException,
			ImageWriteException
	{
		List images = getImagesWithExifData();
		for (int i = 0; i < images.size(); i++)
		{
			File imageFile = (File) images.get(i);
			Debug.debug("imageFile", imageFile);

			ByteSource byteSource = new ByteSourceFile(imageFile);
			Debug.debug("Source Segments:");
			new JpegUtils().dumpJFIF(byteSource);

			{
				JpegImageMetadata metadata = (JpegImageMetadata) Sanselan
						.getMetadata(imageFile);
				assertNotNull(metadata.getExif());
			}

			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				new ExifRewriter().removeExifMetadata(byteSource, baos, null);
				byte bytes[] = baos.toByteArray();
				File tempFile = File.createTempFile("test", ".jpg");
				Debug.debug("tempFile", tempFile);
				tempFile.deleteOnExit();
				IOUtils.writeToFile(bytes, tempFile);

				Debug.debug("Output Segments:");
				new JpegUtils().dumpJFIF(new ByteSourceArray(bytes));

				assertTrue(!hasExifData(tempFile));
			}
		}
	}

	public void testRewrite() throws IOException, ImageReadException,
			ImageWriteException
	{
		List images = getImagesWithExifData();
		for (int i = 0; i < images.size(); i++)
		{
			File imageFile = (File) images.get(i);
			Debug.debug("imageFile", imageFile);

			ByteSource byteSource = new ByteSourceFile(imageFile);
			Debug.debug("Source Segments:");
			new JpegUtils().dumpJFIF(byteSource);

			{
				JpegImageMetadata metadata = (JpegImageMetadata) Sanselan
						.getMetadata(imageFile);
				assertNotNull(metadata.getExif());
				metadata.dump();

				//			TiffImageMetadata tiffImageMetadata = metadata.getExif();
				//			Photoshop photoshop = metadata.getPhotoshop();
			}

			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				new ExifRewriter().removeExifMetadata(byteSource, baos, null);
				byte bytes[] = baos.toByteArray();
				File tempFile = File.createTempFile("test", ".jpg");
				Debug.debug("tempFile", tempFile);
				tempFile.deleteOnExit();
				IOUtils.writeToFile(bytes, tempFile);

				Debug.debug("Output Segments:");
				new JpegUtils().dumpJFIF(new ByteSourceArray(bytes));

				assertTrue(!hasExifData(tempFile));

				JpegImageMetadata metadata = (JpegImageMetadata) Sanselan
						.getMetadata(tempFile);
				//			assertNotNull(metadata);
				//			assertNotNull(metadata.getExif());
				//			metadata.dump();
			}
		}
	}

}