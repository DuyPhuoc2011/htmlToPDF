package htmlToPDF;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class htmlToPDF {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String HTML = "<html>\r\n"
				+ "	<head>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "		<div class = \"header\">\r\n"
				+ "			<span style=\"display: inline-block; margin-left: 90%;\">\r\n"
				+ "				<img src = \"H:\\Direct Card System\\logo.png\" align=\"right\">\r\n"
				+ "			</span>\r\n"
				+ "			<span style=\"display: inline-block;\">\r\n"
				+ "				<h5 style=\"text-align: left;\" >Funds Transfer Request</h5>\r\n"
				+ "			</span>\r\n"
				+ "		</div>\r\n"
				+ "		<hr>\r\n"
				+ "		<div class = \"address\" style=\"text-align: right;\">\r\n"
				+ "            <!-- Amex branch address-->\r\n"
				+ "			<p>www.americanexpress.com.bh</p>\r\n"
				+ "		</div>\r\n"
				+ "		<div class = \"to\" style=\"text-align: left;\">\r\n"
				+ "            <!-- Partner Bank Address-->\r\n"
				+ "		</div>\r\n"
				+ "		<div class = \"body-letter\">\r\n"
				+ "			<p style=\"text-align: center;\">Account to be Debited: <!-- Amex account number--></p>\r\n"
				+ "			<p>\r\n"
				+ "				<span>From: Financial Service</span> \r\n"
				+ "				<span style=\"margin-left: 90%;\">Fax: </span>\r\n"
				+ "			</p>\r\n"
				+ "			<p><!-- AEME Payment rep name-->  </p>\r\n"
				+ "			<p><!-- Date--></p>\r\n"
				+ "			<p><!-- --> As per our agreement, kindly arrange to credit the beneficiaries as per payment Fax/file sent today against the fund of <!--Payment currency & amount--> transferred to your bank, \r\n"
				+ "				valued date <!--Settlement date-->. \r\n"
				+ "			</p>\r\n"
				+ "\r\n"
				+ "			<p>In case you find any disparity in the details submitted to you kindly revert back to us immediately.</p>\r\n"
				+ "			<p>Also provide us a confirmation of the transfer carried out for our records.</p>\r\n"
				+ "			<p>Thank you,</p>\r\n"
				+ "\r\n"
				+ "			<br>\r\n"
				+ "			<br>\r\n"
				+ "			<br>\r\n"
				+ "			\r\n"
				+ "		</div>\r\n"
				+ "		<div class = \"footer\">\r\n"
				+ "			<p><!-- AEME Payment rep name --></p>\r\n"
				+ "			<p><!-- Phone number--></p>\r\n"
				+ "			<p><!-- Email ID--></p>\r\n"
				+ "		</div>\r\n"
				+ "	</body>\r\n"
				+ "</html>";
		
		PDFGenerator(HTML, "H:\\outputFile.pdf");
	}
	
	public static void PDFGenerator(String html, String outputFilePath) throws FileNotFoundException, IOException {
		Document document = Jsoup.parse(html);
		document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
		
		OutputStream os = new FileOutputStream(outputFilePath);
		PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withUri(outputFilePath);
        builder.toStream(os);
	    builder.withW3cDocument(new W3CDom().fromJsoup(document), "/");
		builder.run();
	}

}
