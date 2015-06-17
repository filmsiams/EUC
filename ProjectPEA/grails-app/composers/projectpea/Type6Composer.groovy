package projectpea


class Type6Composer extends zk.grails.Composer {

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
            redirect(uri: "/type6.zul")
        })
       $('#2').on('click',{
            redirect(uri: "/type6-1.zul")
        })      

        $('#cal1').on('click',{

            if($('#volts').text() == "แรงดัน 69 กิโลโวลต์ ขึ้นไป"){

                Float v = Float.valueOf($('#wantvolts').val());
                String vv = String.format("%.0f", v);
                int vvv = Integer.valueOf(vv);
            	
        		Float a = Float.valueOf((vvv*2.9558)+312.24);
            	String aa = String.format("%.2f", a);
            	Float aaa = Float.valueOf(aa);

            	Float b = Float.valueOf((vvv*58.96)/100);
            	String bb = String.format("%.2f", b);
            	Float bbb = Float.valueOf(bb);            	
            	
            	Double c = Double.valueOf(((aaa+bbb)*7)/100);
                String cc = String.format("%.2f", c);
                Float ccc = Float.valueOf(cc); 
                
                Double e = Double.valueOf(aaa+bbb+ccc);
                String ee = String.format("%.2f", e);
                Float eee = Float.valueOf(ee);
                        	
                               
                $('#sum').val(aaa)
                $('#ftd').val(bbb)
                $('#vat').val(ccc)
                $('#sumall').val(eee)
            	

            	}else if($('#volts').text() == "แรงดัน 12 - 24 กิโลโวลต์"){

            		Float v = Float.valueOf($('#wantvolts').val());
	                String vv = String.format("%.0f", v);
	                int vvv = Integer.valueOf(vv);
	            	
	        		Float a = Float.valueOf((vvv*3.1258)+312.24);
	            	String aa = String.format("%.2f", a);
	            	Float aaa = Float.valueOf(aa);

	            	Float b = Float.valueOf((vvv*58.96)/100);
	            	String bb = String.format("%.2f", b);
	            	Float bbb = Float.valueOf(bb);            	
	            	
	            	Double c = Double.valueOf(((aaa+bbb)*7)/100);
	                String cc = String.format("%.2f", c);
	                Float ccc = Float.valueOf(cc); 
	                
	                Double e = Double.valueOf(aaa+bbb+ccc);
	                String ee = String.format("%.2f", e);
	                Float eee = Float.valueOf(ee);
	                        	
	                               
	                $('#sum').val(aaa)
	                $('#ftd').val(bbb)
	                $('#vat').val(ccc)
	                $('#sumall').val(eee)

                	
            		}else if($('#volts').text() == "์แรงดันต่ำกว่า 12 กิโลโวลต์"){

            			Float v = Float.valueOf($('#wantvolts').val());
		                String vv = String.format("%.0f", v);
		                int vvv = Integer.valueOf(vv);
		            	
		            	if(vvv <= 10){
			        		Float a = Float.valueOf((vvv*2.3422)+20);
			            	String aa = String.format("%.2f", a);
			            	Float aaa = Float.valueOf(aa);

			            	Float b = Float.valueOf((vvv*58.96)/100);
			            	String bb = String.format("%.2f", b);
			            	Float bbb = Float.valueOf(bb);            	
			            	
			            	Double c = Double.valueOf(((aaa+bbb)*7)/100);
			                String cc = String.format("%.2f", c);
			                Float ccc = Float.valueOf(cc); 
			                
			                Double e = Double.valueOf(aaa+bbb+ccc);
			                String ee = String.format("%.2f", e);
			                Float eee = Float.valueOf(ee);		                        	
			                               
			                $('#sum').val(aaa)
			                $('#ftd').val(bbb)
			                $('#vat').val(ccc)
			                $('#sumall').val(eee)

		            	}else {

		            		Float a = Float.valueOf((10*2.3422)+((vvv-10)*3.4328)+20);
			            	String aa = String.format("%.2f", a);
			            	Float aaa = Float.valueOf(aa);

			            	Float b = Float.valueOf((vvv*58.96)/100);
			            	String bb = String.format("%.2f", b);
			            	Float bbb = Float.valueOf(bb);            	
			            	
			            	Double c = Double.valueOf(((aaa+bbb)*7)/100);
			                String cc = String.format("%.2f", c);
			                Float ccc = Float.valueOf(cc); 
			                
			                Double e = Double.valueOf(aaa+bbb+ccc);
			                String ee = String.format("%.2f", e);
			                Float eee = Float.valueOf(ee);		                        	
			                               
			                $('#sum').val(aaa)
			                $('#ftd').val(bbb)
			                $('#vat').val(ccc)
			                $('#sumall').val(eee)
		            		}

            			}else {

                			alert("ท่านยังไม่ได้เลือก รหัสแรงดันไฟฟ้าค่ะ")
            			}



        })
        $('#cal2').on('click',{

            $('#wantvolts').val(0)            
            $('#sum').val("")
            $('#ftd').val("")
            $('#vat').val("")
            $('#sumall').val("")

        })

        if(session.euc != null){
            $('#save').src("ext/images/img/save.png")
            $('#cancel').src("ext/images/img/cancel.png")

            }else{

            }
    }
}