package RESTApi;

public class GetPDF {
//	@GET
//	@Path("/getSamplePDF")
//	@ApiOperation(value = "GET: Gives Sample PDF for Validation", notes = "")
//	@ApiResponses({
//			@ApiResponse(code = 500, message = "Internal Server Error")})
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response getSamplePdf() throws IOException, DocumentException{
//	
//		String filePath = environment.getProperty("pdfSample.path");
//
//        
//        
//        PdfReader reader = new PdfReader(filePath + "sample.pdf" );
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(filePath + "out.pdf"));
//        Image img = Image.getInstance(cap.getCaptchaImage(),null);
//        img.setAbsolutePosition(220f, 600f);
//        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
//        PdfContentByte under, over;
//        int total = reader.getNumberOfPages() + 1;
//        for (int i = 1; i < total; i++) {
//          stamper.setRotateContents(false);
//          under = stamper.getUnderContent(i);
//          under.addImage(img);
//
//        }
//        stamper.close();
//        
//        File file = new File(filePath + "out.pdf");
//        		  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//        		      .header("Content-Disposition", "attachment; filename=\"" + cap.getCaptchaString() +".pdf" + "\"" ) //optional
//        		      .build();
//          
//	}
}
