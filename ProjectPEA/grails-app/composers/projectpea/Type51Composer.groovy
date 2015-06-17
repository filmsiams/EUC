package projectpea


class Type51Composer extends zk.grails.Composer {

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

            	Float z = Float.valueOf($('#wantactive').val());
            	String zz = String.format("%.0f", z);
            	int zzz = Integer.valueOf(zz);
            	
        		Float a = Float.valueOf((vvv*74.14));
            	String aa = String.format("%.2f", a);
            	Float aaa = Float.valueOf(aa);

            	Float b = Float.valueOf((xxx*3.5982)+(yyy*2.1572));
            	String bb = String.format("%.2f", b);
            	Float bbb = Float.valueOf(bb);
            	
            	if(zzz >= www){
            	Float c = Float.valueOf(zzz-(www*0.6197));
                String cc = String.format("%.0f", c);
                int ccc = Integer.valueOf(cc);

                Float d = Float.valueOf(ccc*56.07);

                Double e = Double.valueOf(aaa+bbb+d+312.24);
                String ee = String.format("%.2f", e);
                Float eee = Float.valueOf(ee);

                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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
	                int ccc = Integer.valueOf(0);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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

	            	Float z = Float.valueOf($('#wantactive').val());
	            	String zz = String.format("%.0f", z);
	            	int zzz = Integer.valueOf(zz);
	            	
	        		Float a = Float.valueOf((vvv*132.93));
	            	String aa = String.format("%.2f", a);
	            	Float aaa = Float.valueOf(aa);

	            	Float b = Float.valueOf((xxx*3.6796)+(yyy*2.1760));
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);

	            	if(zzz >= www){
	            	Float c = Float.valueOf(zzz-(www*0.6197));	            	
	                String cc = String.format("%.0f", c);
	                int ccc = Integer.valueOf(cc);

	                Float d = Float.valueOf(ccc*56.07);

	                Double e = Double.valueOf(aaa+bbb+d+312.24);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);

	                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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
	            		int ccc = Integer.valueOf(0);

		                Float d = Float.valueOf(ccc*56.07);

		                Double e = Double.valueOf(aaa+bbb+d+312.24);
		                String ee = String.format("%.2f", e);
		                Float eee = Float.valueOf(ee);

		                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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

			            	Float z = Float.valueOf($('#wantactive').val());
			            	String zz = String.format("%.0f", z);
			            	int zzz = Integer.valueOf(zz);
			            	
			        		Float a = Float.valueOf((vvv*210.00));
			            	String aa = String.format("%.2f", a);
			            	Float aaa = Float.valueOf(aa);

			            	Float b = Float.valueOf((xxx*3.8254)+(yyy*2.2092));
			            	String bb = String.format("%.2f", b);
			            	Float bbb = Float.valueOf(bb);		

			            	if(zzz >= www){
			            	Float c = Float.valueOf(zzz-(www*0.6197));
			                String cc = String.format("%.0f", c);
			                int ccc = Integer.valueOf(cc);

			                Float d = Float.valueOf(ccc*56.07);

			                Double e = Double.valueOf(aaa+bbb+d+312.24);
			                String ee = String.format("%.2f", e);
			                Float eee = Float.valueOf(ee);

			                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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

				                int ccc = Integer.valueOf(0);

				                Float d = Float.valueOf(ccc*56.07);

				                Double e = Double.valueOf(aaa+bbb+d+312.24);
				                String ee = String.format("%.2f", e);
				                Float eee = Float.valueOf(ee);

				                Double f = Double.valueOf(((xxx+yyy)*58.96)/100);
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

            $('#wanton').val(0)
            $('#wantoff').val(0)
            $('#poweron').val(0)
            $('#poweroff').val(0)
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