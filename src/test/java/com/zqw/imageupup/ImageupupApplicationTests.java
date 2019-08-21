package com.zqw.imageupup;

import com.zqw.imageupup.api.ImageManageService;
import com.zqw.imageupup.bean.ImageDetailVO;
import com.zqw.imageupup.bean.ImageListVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageupupApplicationTests {

	@Autowired
	private ImageManageService imageManageService;

	@Test
	public void contextLoads() {
		ImageListVO imageList = imageManageService.getImageList(ImageListVO.builder().nextMarker(null).maxKeys(10).build());
		imageList.getImageDetailVOs().forEach(System.out::println);
		System.out.println("-------------------------");
		ImageListVO imageList1 = imageManageService.getImageList(imageList);
		imageList1.getImageDetailVOs().forEach(System.out::println);
	}

}
