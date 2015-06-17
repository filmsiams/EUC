package projectpea


class Type5Composer extends zk.grails.Composer {

    def afterCompose = { window ->
        Date date = new Date()       
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
        
        $('#cal1').src("ext/images/img/cal-1.png")
		$('#cal2').src("ext/images/img/cal-2.png")

       $('#1').on('click',{
            redirect(uri: "/type5.zul")
        })
       $('#2').on('click',{
            redirect(uri: "/type5-1.zul")
        })      

        $('#cal1').on('click',{

            if($('#volts').text() == "แรงดัน 69 กิโลโวลต์ ขึ้นไป"){                

            	Float x = Float.valueOf($('#wantvolts').val());
            	String xx = String.format("%.2f", x);
            	Float xxx = Float.valueOf(xx);

            	Float y = Float.valueOf($('#numvolts').val());
            	String yy = String.format("%.2f", y);
            	Float yyy = Float.valueOf(yy);

            	Float z = Float.valueOf($('#wantactive').val());
            	String zz = String.format("%.2f", z);
            	Float zzz = Float.valueOf(zz);

            	
            		Double a = Double.valueOf(xxx*220.56);
	            	String aa = String.format("%.2f", a);
	            	Double aaa = Double.valueOf(aa);

	            	Double b = Double.valueOf(yyy*2.6506);
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);
	            	
	            	Double c = Double.valueOf(zzz-(xxx*0.6197));

	            	if(c <= 0){	            	
	                
	                int ccc = Integer.valueOf(0);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

	                }else{

	                String cc = String.format("%.0f", c);
	                int ccc = Integer.valueOf(cc);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

	                }     


            	}else if($('#volts').text() == "แรงดัน 12 - 24 กิโลโวลต์"){

            		Float x = Float.valueOf($('#wantvolts').val());
	            	String xx = String.format("%.2f", x);
	            	Float xxx = Float.valueOf(xx);

	            	Float y = Float.valueOf($('#numvolts').val());
	            	String yy = String.format("%.2f", y);
	            	Float yyy = Float.valueOf(yy);

	            	Float z = Float.valueOf($('#wantactive').val());
	            	String zz = String.format("%.2f", z);
	            	Float zzz = Float.valueOf(zz);

            	
            		Double a = Double.valueOf(xxx*256.07);
	            	String aa = String.format("%.2f", a);
	            	Double aaa = Double.valueOf(aa);

	            	Double b = Double.valueOf(yyy*2.6880);
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);
	            	
	            	Double c = Double.valueOf(zzz-(xxx*0.6197));

	            	if(c <= 0){	            	
	                
	                int ccc = Integer.valueOf(0);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

	                }else{

	                String cc = String.format("%.0f", c);
	                int ccc = Integer.valueOf(cc);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)
	                }
                		
            		}else if($('#volts').text() == "์แรงดันต่ำกว่า 12 กิโลโวลต์"){

            		Float x = Float.valueOf($('#wantvolts').val());
	            	String xx = String.format("%.2f", x);
	            	Float xxx = Float.valueOf(xx);

	            	Float y = Float.valueOf($('#numvolts').val());
	            	String yy = String.format("%.2f", y);
	            	Float yyy = Float.valueOf(yy);

	            	Float z = Float.valueOf($('#wantactive').val());
	            	String zz = String.format("%.2f", z);
	            	Float zzz = Float.valueOf(zz);

            	
            		Double a = Double.valueOf(xxx*276.64);
	            	String aa = String.format("%.2f", a);
	            	Double aaa = Double.valueOf(aa);

	            	Double b = Double.valueOf(yyy*2.7160);
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);
	            	
	            	Double c = Double.valueOf(zzz-(xxx*0.6197));

	            	if(c <= 0){	            	
	                
	                int ccc = Integer.valueOf(0);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

	                }else{

	                String cc = String.format("%.0f", c);
	                int ccc = Integer.valueOf(cc);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf((yyy*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((eee+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(eee+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)
	            	$('#b3').val(ccc)
	                $('#all').val(d)
	                $('#service').val(312.24)
	                $('#sum').val(eee)
	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

	                }            				

            			}else {

                			alert("ท่านยังไม่ได้เลือก รหัสแรงดันไฟฟ้าค่ะ")
            			}
        })
        $('#cal2').on('click',{

            $('#wantvolts').val(0)
            $('#numvolts').val(0)
            $('#wantactive').val(0)
            $('#b1').val("")
            $('#b2').val("")
            $('#b3').val("")
            $('#all').val("")
            $('#service').val("")
            $('#sum').val("")
            $('#ftd').val("")
            $('#vat').val("")
            $('#sumall').val("")

        })
    }
}