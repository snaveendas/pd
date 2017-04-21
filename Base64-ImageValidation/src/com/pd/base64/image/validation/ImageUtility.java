/**
 * 
 */
package com.pd.base64.image.validation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * @author psivadas
 *
 */
public class ImageUtility {

	Logger logger = Logger.getLogger(ImageUtility.class);

	public String encodeToBase64String(String filePath)
	{
		String base64ImageString = null;
		try {
			base64ImageString = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(filePath)));
			logger.info("Encoded Base64 Image String type - "+base64ImageString);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64ImageString;
	}


	public String DecodeAndValidateImageType(String base64ImageString)
	{
		//decode the Base64 Image String
		byte[] imageByteArray = Base64.getDecoder().decode(base64ImageString );

		InputStream is = new ByteArrayInputStream(imageByteArray);

		//Find out image type
		String mimeType = null;
		String fileExtension = null;

		try {
			mimeType = URLConnection.guessContentTypeFromStream(is); //mimeType is something like "image/jpeg"
			logger.info("mime type - "+mimeType);
			String delimiter="[/]";
			String[] tokens = mimeType.split(delimiter);
			fileExtension = tokens[1];
			logger.info("fileExtension - "+fileExtension);
		} catch (IOException ioException){

		}

		return fileExtension;
	}

}
