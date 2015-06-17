package projectpea
import java.util.*
import java.lang.*
import org.zkoss.zk.ui.Component
import org.zkoss.zul.*
import org.zkoss.zk.ui.event.*

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import java.io.FileOutputStream

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.Image;
import com.itextpdf.text.Chunk;

import javax.servlet.http.*;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.ServletException;  


class PrintbillComposer extends zk.grails.Composer {

    def afterCompose = { window ->
        Date date = new Date() 

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat() 
        df.applyPattern("MMM/yyyy")      
        java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat()        
        tf.applyPattern("HH:mm:ss")

        $('#userlogin').val(session.user)
        def ckn = Logincheck.findByUser(session.user)
        if(ckn == null){
            alert("ท่านยังไม่ทำการ login ค่ะ")
            redirect(uri: "/login.zul")
        }
        $('#logout').on('click',{
          def del = Logincheck.findByUser(session.user)
            def ch = Employee.findByEmid(session.user)
                def outadd = Logindata.findByCkin(session.ckin)


            if(ch != null){

                ch.cedit = ""
                ch.editin = ""
                ch.save()
            }else{
                      
            }
                

          if(del != null){            

            outadd.timelogout = tf.format(date)
            outadd.ckin = "out"
            outadd.save()

            session.ckin = ""
            session.user = ""
            session.claim = ""            
            del.delete()

            redirect(uri: "/login.zul")
          }else{
            redirect(uri: "/login.zul")
          }
    	})

        //--------------------------------------------------------------------------

        def show = Paytype1.findByBillid(session.bill)

        def shows = Request.findByNouser(show.nouser)

        if(show != null){

            $('#iduse').val(show.nouser)
            $('#billno').val(session.bill)
            $('#type').val(show.type)
            $('#press').val(show.press)
            $('#month').val(show.month)

            $('#name').val(shows.name)
            $('#address').val(shows.contact+" เลขที่ "+shows.nohome3+" อาคาร "
                +shows.nhome3+" ห้อง "+shows.room3+" ชั้น "+shows.floor3+" ตรอก "+shows.trog3+" ซอย"
                +shows.soy3+" ถ."+shows.road3+" ม."+shows.moo3+" ต."+shows.tumbon3+" อ."
                +shows.aumpher3+" จ."+shows.city3+" "+shows.post3)

            $('#after').val(show.afteruse)
            $('#befor').val(show.beforuse)

            $('#onp').val(show.onpeak)
            $('#offp').val(show.offpeak)

            $('#use').val(show.poweruse)
            $('#paybase').val(show.paybase)
            $('#ftbase').val(show.ftbase)
            $('#vat').val(show.vatbase)
            $('#all').val(show.sumall)
            $('#sumall').val(show.payall)

            if(show.status == "ค้างชำระ"){

                $('#st').val("ค้างชำระ").style("font-weight:bold; color:red; font-size:30px")
                

            }else{

                $('#st').val("ชำระแล้ว").style("font-weight:bold; color:green; font-size:30px")
                
                $('#green').disabled("true").style("font-weight:bold; font-size:20px")
                $('#red').disabled("true").style("font-weight:bold; font-size:20px")
            
            }

        }else{

            alert("ขัดข้องค่ะ")
        }

//--------------------------------------------------------------------------------------------

        $('#green').on('click',{

            $('#green').disabled("true").style("font-weight:bold; font-size:20px")
            $('#red').disabled("").style("font-weight:bold; color:red; font-size:20px")

            })

        $('#red').on('click',{

            $('#green').disabled("").style("font-weight:bold; color:green; font-size:20px")
            $('#red').disabled("true").style("font-weight:bold; font-size:20px")

            })

//--------------------------------------------------------------------------------------------

        $('#save').on('click',{
                        
            def add = Paytype1.findByBillid(session.bill)
           
            if($('#green').disabled() == true){
           
                add.status = "ชำระแล้ว"

            }else{

                add.status = "ค้างชำระ"
            }

            alert("บันทึกเรียบร้อยค่ะ")

            $('#print').setHref("static/ext/pdf/"+billid()+".pdf");
            $('#print').setTarget("_new");
            
            createpdf();

            //redirect(uri: "/printbill.zul")

        })

//--------------------------------------------------------------------------------------------
            $('#print').on('click',{     

            //redirect(uri: "/payment.zul")
            
            })
//--------------------------------------------------------------------------------------------
    }

public String billid(){

        String gg = session.bill;

        return gg
    }

public String GetString(String str) {          
        return str
    } 

public void createpdf(){
    try {
        Rectangle pagesize = new Rectangle(200f, 320f)
        Document document = new Document(pagesize, 20f, 3f, 3f, 3f)
        PdfWriter.getInstance(document, new FileOutputStream(application.getRealPath("/ext/pdf/"+billid()+".pdf")));
        document.open();
        addMetaData(document);
        addTitlePage(document);             
        document.close();        

    }   catch(Exception e){
            print(e)
            alert("เกิดข้อผิดพลาดในการสร้างใบเสร็จ กรุณากรอกข้อมูลร้านให้ครบ")
    }
}

private void addMetaData(Document document) {
    document.addTitle("ใบแจ้งค่าไฟฟ้า");
    document.addSubject("Using iText");
    document.addKeywords("Java, PDF, iText");
    document.addAuthor("Lars Vogel");
    document.addCreator("Lars Vogel");
}

private void addTitlePage(Document document) throws DocumentException {
    BaseFont basefont;

    String billid
    String nouser
    String beforuse
    String afteruse
    String poweruse
    String type
    String press
    String onpeak
    String offpeak
    String paybase
    String ftbase
    String vatbase
    String payall
    String month

    basefont = BaseFont.createFont(application.getRealPath("ARIALUNI.ttf"), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font catFont = new Font(basefont, 7,Font.BOLD);
    //Font redFont = new Font(basefont, 8,Font.NORMAL, BaseColor.RED);
    //Font smallBold = new Font(basefont, 7,Font.BOLD);
    //Font smallNomal = new Font(basefont, 8,Font.NORMAL);
    LineSeparator line = new LineSeparator();

    def showdata = Paytype1.findByBillid(session.bill)
    def shows = Request.findByNouser(showdata.nouser)   


    Paragraph blank = new Paragraph("----------------------------------------");
    blank.add(new Paragraph(" "));
    blank.setAlignment(Element.ALIGN_CENTER);

    Date date = new Date() 
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat() 
    df.applyPattern(" d MMM yy ',' HH:mm 'น.'")

    Paragraph dateandtime = new Paragraph(df.format(date),catFont);
    dateandtime.add(new Paragraph(" "));
    dateandtime.setAlignment(Element.ALIGN_RIGHT);

    Paragraph rowone = new Paragraph("111SUT"+"                    "+showdata.nouser+"                           "+showdata.billid, catFont);
    rowone.setAlignment(Element.ALIGN_CENTER);

    addEmptyLine(rowone, 1);          
    
    Paragraph rowtwo = new Paragraph(showdata.type+"                    "+showdata.press+"                    "+showdata.month, catFont);
    rowtwo.setAlignment(Element.ALIGN_CENTER);

    addEmptyLine(rowtwo, 1);

    Paragraph rowtree = new Paragraph("                  "+shows.name+"  "+shows.contact+" เลขที่ "+shows.nohome3+" อาคาร "
                +shows.nhome3+" ห้อง "+shows.room3+" ชั้น "+shows.floor3+" ตรอก "+shows.trog3+" ซอย"
                +shows.soy3+" ถ."+shows.road3+" ม."+shows.moo3+" ต."+shows.tumbon3+" อ."
                +shows.aumpher3+" จ."+shows.city3+" "+shows.post3, catFont);

    addEmptyLine(rowtree, 1);

    Paragraph rowfour = new Paragraph(showdata.afteruse+"                         "+showdata.beforuse+"                            "+showdata.poweruse+"     ", catFont);
    rowfour.setAlignment(Element.ALIGN_RIGHT);

    addEmptyLine(rowfour, 1);

    Paragraph rowfive = new Paragraph("0.00"+"                                         "+showdata.paybase+"     ", catFont);
    rowfive.setAlignment(Element.ALIGN_RIGHT);

    Paragraph rowsix = new Paragraph("58.96"+"                                         "+showdata.ftbase+"     ", catFont);
    rowsix.setAlignment(Element.ALIGN_RIGHT);

    addEmptyLine(rowsix, 1);

    Paragraph rowseven = new Paragraph(showdata.sumall+"     ", catFont);
    rowseven.setAlignment(Element.ALIGN_RIGHT);

    Paragraph roweight = new Paragraph("7"+"                            "+showdata.vatbase+"     ", catFont);
    roweight.setAlignment(Element.ALIGN_RIGHT)

    Paragraph rownine = new Paragraph("***"+showdata.payall+"     ", catFont);
    rownine.setAlignment(Element.ALIGN_RIGHT)

    addEmptyLine(rownine, 1);
    
    java.text.SimpleDateFormat mmm = new java.text.SimpleDateFormat() 
    mmm.applyPattern("MMM")
    java.text.SimpleDateFormat yyyy = new java.text.SimpleDateFormat() 
    yyyy.applyPattern("yyyy")

    
    String day;

    if(mmm.format(date) == "ก.พ."){
        day = "20-28 ";
    }else{
        day = "20-29 ";
    }

    Paragraph rowten = new Paragraph("                    "+day+mmm.format(date)+" "+yyyy.format(date), catFont);
    rowten.setAlignment(Element.ALIGN_CENTER)

    document.add(blank);
    document.add(dateandtime);
    document.add(rowone);
    document.add(rowtwo); 
    document.add(rowtree); 
    document.add(rowfour); 
    document.add(rowfive);
    document.add(rowsix);
    document.add(rowseven);
    document.add(roweight);
    document.add(rownine);
    document.add(rowten);

document.newPage();
   
}

private void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}

}