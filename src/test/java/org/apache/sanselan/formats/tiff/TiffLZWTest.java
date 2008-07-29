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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.common.BinaryConstants;
import org.apache.sanselan.common.byteSources.ByteSource;
import org.apache.sanselan.common.byteSources.ByteSourceFile;
import org.apache.sanselan.common.mylzw.MyLZWCompressor;
import org.apache.sanselan.common.mylzw.MyLZWDecompressor;
import org.apache.sanselan.util.Debug;

public class TiffLZWTest extends TiffBaseTest implements BinaryConstants
{

	public void testTrivial() throws IOException
	{
		byte bytes[] = { 0, };
		compressRoundtripAndValidate(bytes);
	}

	public void testMedium() throws IOException
	{
		int LENGTH = 1024 * 32;
		byte bytes[] = new byte[LENGTH];
		for (int modulator = 1; modulator < 255; modulator += 3)
		{
			for (int i = 0; i < LENGTH; i++)
				bytes[i] = (byte) (0xff & (i % modulator));

			compressRoundtripAndValidate(bytes);
		}
	}

//	public void testTiffImageData() throws IOException, ImageReadException,
//			ImageWriteException
//	{
//		List images = getTiffImages();
//		for (int i = 0; i < images.size(); i++)
//		{
//			if (i % 10 == 0)
//				Debug.purgeMemory();
//
//			File imageFile = (File) images.get(i);
//			Debug.debug("imageFile", imageFile);
//
//			ByteSource byteSource = new ByteSourceFile(imageFile);
//			Map params = new HashMap();
//			List data = new TiffImageParser().collectRawImageData(byteSource,
//					params);
//
//			for (int j = 0; j < data.size(); j++)
//			{
//				byte bytes[] = (byte[]) data.get(j);
//				decompressRoundtripAndValidate(bytes);
//			}
//		}
//	}

	private void compressRoundtripAndValidate(byte src[]) throws IOException
	{
		final boolean DEBUG = false;

		if (DEBUG)
		{
			Debug.debug();
			Debug.debug("roundtripAndValidate: " + src.length);
			Debug.debug();
		}

		int LZW_MINIMUM_CODE_SIZE = 8;
		final List codes = new ArrayList();
		MyLZWCompressor.Listener compressionListener = new MyLZWCompressor.Listener() {
			public void dataCode(int code)
			{
				codes.add(new Integer(code));
			}

			public void eoiCode(int code)
			{
				codes.add(new Integer(code));
			}

			public void clearCode(int code)
			{
				codes.add(new Integer(code));
			}

			public void init(int clearCode, int eoiCode)
			{
			}
		};

		MyLZWCompressor compressor = new MyLZWCompressor(LZW_MINIMUM_CODE_SIZE,
				BYTE_ORDER_MSB, true, compressionListener);
		byte compressed[] = compressor.compress(src);

		MyLZWDecompressor.Listener decompressionListener = new MyLZWDecompressor.Listener() {

			int index = 0;
			int clearCode, eoiCode;

			public void code(int code)
			{
				if (DEBUG)
				{
					if (code == clearCode)
					{
						Debug.debug("clearCode: " + index + "/" + codes.size());
						Debug.debug();
					}
					if (code == eoiCode)
					{
						Debug.debug("eoiCode: " + index + "/" + codes.size());
						Debug.debug();
					}
				}
				Integer expectedCode = (Integer) codes.get(index++);
				if (code != expectedCode.intValue())
				{
					Debug.debug("bad code: " + index + "/" + codes.size());
					Debug.debug("code: " + code + " (0x"
							+ Integer.toHexString(code) + ") "
							+ Integer.toBinaryString(code));
					Debug.debug("expected: " + expectedCode + " (0x"
							+ Integer.toHexString(expectedCode.intValue())
							+ ") "
							+ Integer.toBinaryString(expectedCode.intValue()));
					Debug.debug("clearCode: " + clearCode + " (0x"
							+ Integer.toHexString(clearCode) + ") "
							+ Integer.toBinaryString(clearCode));
					Debug.debug("eoiCode: " + eoiCode + " (0x"
							+ Integer.toHexString(eoiCode) + ") "
							+ Integer.toBinaryString(eoiCode));
					Debug.debug();
				}
			}

			public void init(int clearCode, int eoiCode)
			{
				this.clearCode = clearCode;
				this.eoiCode = eoiCode;
			}

		};
		InputStream is = new ByteArrayInputStream(compressed);
		MyLZWDecompressor decompressor = new MyLZWDecompressor(
				LZW_MINIMUM_CODE_SIZE, BYTE_ORDER_NETWORK,
				decompressionListener);
		decompressor.setTiffLZWMode();
		byte decompressed[] = decompressor.decompress(is, src.length);

		assertEquals(src.length, decompressed.length);
		for (int i = 0; i < src.length; i++)
			assertEquals(src[i], decompressed[i]);
	}

	private void decompressRoundtripAndValidate(byte src[]) throws IOException
	{
		Debug.debug();
		Debug.debug("roundtripAndValidate: " + src.length);
		Debug.debug();

		int LZW_MINIMUM_CODE_SIZE = 8;
		final List codes = new ArrayList();

		MyLZWDecompressor.Listener decompressionListener = new MyLZWDecompressor.Listener() {

			public void code(int code)
			{
				Debug.debug("listener code: " + code + " (0x"
						+ Integer.toHexString(code) + ") "
						+ Integer.toBinaryString(code) + ", index: "
						+ codes.size());
				codes.add(new Integer(code));
			}

			public void init(int clearCode, int eoiCode)
			{
			}

		};
		InputStream is = new ByteArrayInputStream(src);
		MyLZWDecompressor decompressor = new MyLZWDecompressor(
				LZW_MINIMUM_CODE_SIZE, BYTE_ORDER_NETWORK,
				decompressionListener);
		decompressor.setTiffLZWMode();
		byte decompressed[] = decompressor.decompress(is, src.length);

		MyLZWCompressor.Listener compressionListener = new MyLZWCompressor.Listener() {

			int clearCode, eoiCode;

			public void init(int clearCode, int eoiCode)
			{
				this.clearCode = clearCode;
				this.eoiCode = eoiCode;
			}

			int index = 0;

			private void code(int code)
			{

				if (code == clearCode)
				{
					Debug.debug("clearCode: " + index + "/" + codes.size());
					Debug.debug();
				}
				if (code == eoiCode)
				{
					Debug.debug("eoiCode: " + index + "/" + codes.size());
					Debug.debug();
				}
				Integer expectedCode = (Integer) codes.get(index++);
				if (code != expectedCode.intValue())
				{
					Debug.debug("bad code: " + index + "/" + codes.size());
					Debug.debug("code: " + code + " (0x"
							+ Integer.toHexString(code) + ") "
							+ Integer.toBinaryString(code));
					Debug.debug("expected: " + expectedCode + " (0x"
							+ Integer.toHexString(expectedCode.intValue())
							+ ") "
							+ Integer.toBinaryString(expectedCode.intValue()));
					Debug.debug("clearCode: " + clearCode + " (0x"
							+ Integer.toHexString(clearCode) + ") "
							+ Integer.toBinaryString(clearCode));
					Debug.debug("eoiCode: " + eoiCode + " (0x"
							+ Integer.toHexString(eoiCode) + ") "
							+ Integer.toBinaryString(eoiCode));
					Debug.debug();
				}
			}

			public void dataCode(int code)
			{
				code(code);
			}

			public void eoiCode(int code)
			{
				code(code);
			}

			public void clearCode(int code)
			{
				code(code);
			}

		};

		MyLZWCompressor compressor = new MyLZWCompressor(LZW_MINIMUM_CODE_SIZE,
				BYTE_ORDER_MSB, true, compressionListener);
		byte compressed[] = compressor.compress(decompressed);

		assertEquals(src.length, compressed.length);
		for (int i = 0; i < src.length; i++)
			assertEquals(src[i], compressed[i]);
	}

}
