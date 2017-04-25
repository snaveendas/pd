/**
 * 
 */
package com.pd.base64.image.validation;

import org.junit.Test;

/**
 * @author psivadas
 *
 */
public class ImageUtilityTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidImageExtenstion(){
		String base64ImageString = null;
		String extentionType = null;
		
		ImageUtility imageUtility = new ImageUtility();
		
		//Encode to Base64 Image String
		base64ImageString = imageUtility.encodeToBase64String("C:\\Users\\Naveen\\Desktop\\Logo.png");
		
		//Decode and fetch the image extension type
		extentionType = imageUtility.DecodeAndValidateImageType(base64ImageString);
		
		assert(extentionType.equals("png"));
	}
	
	@Test
	public void testImageExtenstion(){
		String base64ImageString = null;
		String extentionType = null;
		
		ImageUtility imageUtility = new ImageUtility();
		
		//Encode to Base64 Image String
		base64ImageString = imageUtility.encodeToBase64String("C:\\Users\\Naveen\\Desktop\\clubcabana\\IMG_3995.jpg");
		
		//Decode and fetch the image extension type
		extentionType = imageUtility.DecodeAndValidateImageType(base64ImageString);
		
		assert(extentionType.equals("jpeg"));
	}
	
	
}
