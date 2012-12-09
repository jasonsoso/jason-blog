package com.jason.blog.infrastruture.spring.security.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.ImageFilter;

import com.jhlabs.image.RippleFilter;
import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.gimpy.DefaultGimpyEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

public class JCaptchaEngine extends DefaultGimpyEngine {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.octo.captcha.engine.image.gimpy.DefaultGimpyEngine#buildInitialFactories()
	 */
	@Override
	protected void buildInitialFactories() {
		int minWordLength = 4;
		int maxWordLength = 5;
		int fontSize = 22;
		int imageWidth = 100;
		int imageHeight = 32;

		WordGenerator wgen = new RandomWordGenerator("abdefghjkmnpqrstuvwxyz23456789");

		RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(new int[] { 0, 100 }, new int[] { 0, 100 }, new int[] {0, 100 });

		TextPaster textPaster = new DecoratedRandomTextPaster(minWordLength, maxWordLength, cgen, new TextDecorator[] {});

		BackgroundGenerator bggen = new UniColorBackgroundGenerator(imageWidth, imageHeight, Color.white);

		Font[] fonts = new Font[] { new Font("Arial", Font.BOLD, fontSize),
									new Font("Tahoma", Font.BOLD, fontSize),
									new Font("Verdana", Font.BOLD, fontSize) };

		FontGenerator fgen = new RandomFontGenerator(fontSize, fontSize, fonts);

		ImageDeformation backgroundDeformation = new ImageDeformationByFilters(new ImageFilter[] {});
		ImageDeformation textDeformation = new ImageDeformationByFilters(new ImageFilter[] {new RippleFilter()});
		ImageDeformation finalDeformation = new ImageDeformationByFilters(new ImageFilter[] {});

		WordToImage word2image = new DeformedComposedWordToImage(fgen,
																	bggen,
																	textPaster,
																	backgroundDeformation,
																	textDeformation,
																	finalDeformation);

		addFactory(new GimpyFactory(wgen, word2image));
	}
}
