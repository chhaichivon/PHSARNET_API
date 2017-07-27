package com.psarnet.api.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.psarnet.api.entities.Product;
import com.psarnet.api.entities.ProductTemperory;
import com.psarnet.api.entities.SourceCategory;
import com.psarnet.api.entities.SubTwoCategory;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.services.ProductService;
import com.psarnet.api.services.ProductTmpService;
import com.psarnet.api.services.SourceCategoryService;

@Controller
@EnableScheduling
public class ProductScrapping {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private ProductTmpService pts;
	
	@Autowired 
	private SourceCategoryService scs;

	/**
	 * Scrap data auto by set fixed delay
	 */
	@Scheduled(fixedDelay =90000000)
	private void startScrapProduct(){   
		Pattern pattern = Pattern.compile(".*'([^']*)'.*");
		ArrayList<SourceCategory> lists = scs.getAllUrlToScrap();
		for(SourceCategory s : lists)
		{		
			if(s.isStatus() == true)
			{
				
				try {
					List<Product> products = new ArrayList<>();
					Product p = new Product();
					SubTwoCategory s2 = new SubTwoCategory();
					Document doc =Jsoup.connect(s.getSourcecategory()).timeout(9000).userAgent("Mozila").get();
					Elements els = doc.select(s.getSource().getRowsselector());
					for(Element el : els){
						String title = el.select(s.getSource().getTitleselector()).text();
						String image = el.select(s.getSource().getImageselector()).attr(s.getSource().getImageattribute());
						String price = el.select(s.getSource().getPriceselector()).text();
						String url = el.select(s.getSource().getLinkselector()).attr("href");
						Matcher matcher = pattern.matcher(image);
						String getPrice = "0";
						System.out.println("=======>> "+price);
						System.out.println("=======>> "+url);
						if(!price.trim().equals("") ){
								 getPrice = price.replace("$","");
								 getPrice = getPrice.replace(",","");
								 getPrice = getPrice.replace("USD","");
								 //getPrice = price.replace("$","");
								 getPrice = getPrice.replace("៛","");
						}
						if(matcher.matches()) {
					            image=matcher.group(1);
					     }
						p.setUrl(url);
						p.setImage(image);
						p.setTitle(title+" "+s.getSubCategory().getCategoryname());
						p.setPrice(Double.parseDouble(getPrice));
						s.getSourcecategoryid();
						p.setSourceCategory(s);
						s2.setSubtwocategoryid(s.getSubCategory().getSubtwocategoryid());
						p.setSubtwoCategory(s2);
						products.add(p);
						ps.addProducts(products);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s.isStatus() == false)
			{
				try {
					List<ProductTemperory> productstmp = new ArrayList<>();
					ProductTemperory p = new ProductTemperory();
					SubTwoCategory s2 = new SubTwoCategory();
					Document doc =Jsoup.connect(s.getSourcecategory()).timeout(9000).userAgent("Mozila").get();
					Elements els = doc.select(s.getSource().getRowsselector());
					for(Element el : els){
						String title = el.select(s.getSource().getTitleselector()).text();
						String image = el.select(s.getSource().getImageselector()).attr(s.getSource().getImageattribute());
						String price = el.select(s.getSource().getPriceselector()).text();
						String url = el.select(s.getSource().getLinkselector()).attr("href");
						Matcher matcher = pattern.matcher(image);
						String getPrice = "0";
						if(!price.trim().equals("") ){
								 getPrice = price.replace("$","");
								 getPrice = getPrice.replace(",","");
								 getPrice = getPrice.replace("USD","");
						}
						if(matcher.matches()) {
					            image=matcher.group(1);
					     }
						p.setUrl(url);
						p.setImage(image);
						p.setTitle(title);
						p.setPrice(Double.parseDouble(getPrice));
						s.getSourcecategoryid();
						p.setSourceCategory(s);
						s2.setSubtwocategoryid(s.getSubCategory().getSubtwocategoryid());
						p.setSubTwoCategory(s2);
						productstmp.add(p);
						pts.createProductTemperory(productstmp);
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
	
}
