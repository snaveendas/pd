/**
 * 
 */
package com.pd.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Preconditions;
import com.pd.base64.image.validation.ImageUtility;

/**
 * @author psivadas
 *
 */
public class ImageTypeConstraintValidator implements ConstraintValidator<ImageType, String>{

	@Override
	public void initialize(ImageType imageType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String base64ImageString, ConstraintValidatorContext context) {
		
		String fileExtension = null;
		ImageUtility imageUtility = new ImageUtility();
		fileExtension = imageUtility.DecodeAndValidateImageType(base64ImageString);
		Preconditions.checkArgument(fileExtension.equals("jpg"), "Only jpeg file is supported");
		if(!fileExtension.equals(""))
			return true;
		else
			return false;
	}

}
