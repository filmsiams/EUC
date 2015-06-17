package projectpea


class Type71Composer extends zk.grails.Composer {

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
            redirect(uri: "/type7.zul")
        })
       $('#2').on('click',{
            redirect(uri: "/type7-1.zul")
        })      

        $('#cal1').on('click',{

            if($('#volts').text() == "แรงดัน 12 - 24 กิโลโวลต์"){

                Float v = Float.valueOf($('#wanton').val());
                String vv = String.format("%.0f", v);
                int vvv = Integer.valueOf(vv);

                Float w = Float.valueOf($('#wantoff').val());
                String ww = String.format("%.0f", w);
                int www = Integer.valueOf(ww);

            	Float x = Float.valueOf($('#poweron').val());
            	String xx = String.format("%.0f", x);
            	int xxx = Integer.valueOf(xx);

            	Float y = Float.valueOf($('#poweroff').val());
            	String yy = String.format("%.0f", y);
            	int yyy = Integer.valueOf(yy);
            	
            	
        		Float a = Float.valueOf((vvv*132.93));
            	String aa = String.format("%.2f", a);
            	Float aaa = Float.valueOf(aa);

            	Float b = Float.valueOf((xxx*3.6531)+(yyy*2.1495));
            	String bb = String.format("%.2f", b);
            	Float bbb = Float.valueOf(bb);       	
            	                
                Double c = Double.valueOf(aaa+bbb+228.17);
                String cc = String.format("%.2f", c);
                Float ccc = Float.valueOf(cc);

                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
                String ff = String.format("%.2f", f);
                Float fff = Float.valueOf(ff);

                Double g = Double.valueOf(((ccc+fff)*7)/100);
                String gg = String.format("%.2f", g);
                Float ggg = Float.valueOf(gg);

                Double h = Double.valueOf(ccc+fff+ggg);
                String hh = String.format("%.2f", h);
                Float hhh = Float.valueOf(hh);

            	$('#b1').val(aaa)
            	$('#b2').val(bbb)           	

                $('#service').val(228.17)

                $('#sum').val(ccc)

                $('#ftd').val(fff)
                $('#vat').val(ggg)
                $('#sumall').val(hhh)
            	

            	}else if($('#volts').text() == "แรงดันต่ำกว่า 12 กิโลโวลต์"){
            		Float v = Float.valueOf($('#wanton').val());
	                String vv = String.format("%.0f", v);
	                int vvv = Integer.valueOf(vv);

	                Float w = Float.valueOf($('#wantoff').val());
	                String ww = String.format("%.0f", w);
	                int www = Integer.valueOf(ww);

	            	Float x = Float.valueOf($('#poweron').val());
	            	String xx = String.format("%.0f", x);
	            	int xxx = Integer.valueOf(xx);

	            	Float y = Float.valueOf($('#poweroff').val());
	            	String yy = String.format("%.0f", y);
	            	int yyy = Integer.valueOf(yy);
	            	
	            	
	        		Float a = Float.valueOf((vvv*210));
	            	String aa = String.format("%.2f", a);
	            	Float aaa = Float.valueOf(aa);

	            	Float b = Float.valueOf((xxx*3.7989)+(yyy*2.1827));
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);       	
	            	                
	                Double c = Double.valueOf(aaa+bbb+228.17);
	                String cc = String.format("%.2f", c);
	                Float ccc = Float.valueOf(cc);

	                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
	                String ff = String.format("%.2f", f);
	                Float fff = Float.valueOf(ff);

	                Double g = Double.valueOf(((ccc+fff)*7)/100);
	                String gg = String.format("%.2f", g);
	                Float ggg = Float.valueOf(gg);

	                Double h = Double.valueOf(ccc+fff+ggg);
	                String hh = String.format("%.2f", h);
	                Float hhh = Float.valueOf(hh);

	            	$('#b1').val(aaa)
	            	$('#b2').val(bbb)           	

	                $('#service').val(228.17)

	                $('#sum').val(ccc)

	                $('#ftd').val(fff)
	                $('#vat').val(ggg)
	                $('#sumall').val(hhh)

                	

            		}else {
                			alert("ท่านยังไม่ได้เลือก รหัสแรงดันไฟฟ้าค่ะ")
            			}



        })
        $('#cal2').on('click',{

            $('#wanton').val(0)
            $('#wantoff').val(0)
            $('#poweron').val(0)
            $('#poweroff').val(0)
            
            $('#b1').val("")
            $('#b2').val("")            
            
            $('#service').val("")
            $('#sum').val("")
            $('#ftd').val("")
            $('#vat').val("")
            $('#sumall').val("")

        })
    }
}