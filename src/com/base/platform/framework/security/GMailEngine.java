package com.base.platform.framework.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.ImageFilter;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.FileDictionary;
import com.octo.captcha.component.word.wordgenerator.ComposeDictionaryWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

/**
 * JCaptcha验证码图片生成引擎,仿照JCaptcha2.0编写类似GMail验证码的样式.
 */
public class GMailEngine extends ListImageCaptchaEngine {
    
    private static final int minWordLength = 3;
    private static final int maxWordLength = 3;
    private static final int fontSize      = 20;
    private static final int imageWidth    = 90;
    private static final int imageHeight   = 27;
    
    
    @Override
    protected void buildInitialFactories() {
        WordGenerator dictionnaryWords = new ComposeDictionaryWordGenerator(new FileDictionary("toddlist"));
        TextPaster randomPaster = new DecoratedRandomTextPaster(GMailEngine.minWordLength , GMailEngine.maxWordLength , new RandomListColorGenerator(new Color[] { new Color(0 , 0 , 0) }) ,
                new TextDecorator[] {});
        BackgroundGenerator background = new UniColorBackgroundGenerator(GMailEngine.imageWidth , GMailEngine.imageHeight , Color.lightGray);
        FontGenerator font = new RandomFontGenerator(GMailEngine.fontSize , GMailEngine.fontSize , new Font[] { new Font("Arial" , Font.BOLD , GMailEngine.fontSize) });
        ImageDeformation postDef = new ImageDeformationByFilters(new ImageFilter[] {});
        ImageDeformation backDef = new ImageDeformationByFilters(new ImageFilter[] {});
        ImageDeformation textDef = new ImageDeformationByFilters(new ImageFilter[] {});
        WordToImage word2image = new DeformedComposedWordToImage(font , background , randomPaster , backDef , textDef , postDef);
        addFactory(new GimpyFactory(dictionnaryWords , word2image));
    }
    
}
