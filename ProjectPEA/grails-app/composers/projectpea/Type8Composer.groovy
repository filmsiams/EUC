package projectpea


class Type8Composer extends zk.grails.Composer {

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
            redirect(uri: "/type8.zul")
        })
            

        $('#cal1').on('click',{            

                Float v = Float.valueOf($('#wantvolts').val());
                String vv = String.format("%.0f", v);
                int vvv = Integer.valueOf(vv);
            	
        		Float a = Float.valueOf(vvv*6.3434);
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
                        	
                $('#numvolts').val(6.3434)               
                $('#sum').val(aaa)
                $('#ftd').val(bbb)
                $('#vat').val(ccc)
                $('#sumall').val(eee)         	            	

        })
        $('#cal2').on('click',{

            $('#wantvolts').val(0)
            $('#numvolts').val("")            
            $('#sum').val("")
            $('#ftd').val("")
            $('#vat').val("")
            $('#sumall').val("")

        })
    }
}