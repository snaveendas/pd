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

import com.google.common.base.Preconditions;
import com.pd.annotation.ImageType;

/**
 * @author psivadas
 *
 */
public class ImageUtility {

	Logger logger = Logger.getLogger(ImageUtility.class);

	/**
	 * Method to read a file and encode as Base64 encoded String
	 * @param filePath
	 * @return encoded String
	 */
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


	/**
	 * Method to decode the Base64 encoded string and validate the Image Mime Type
	 * @param base64ImageString
	 * @return
	 */
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
			Preconditions.checkArgument(fileExtension.equals("jpeg"), "Only jpeg file is supported");
			logger.info("fileExtension - "+fileExtension);
		} catch (IOException ioException){

		}

		return fileExtension;
	}

}
