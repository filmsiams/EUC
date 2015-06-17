package projectpea


class Type7Composer extends zk.grails.Composer {

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

            int x = Integer.valueOf($('#use').val());

            if(x <= 100){

            	Float a = Float.valueOf((x*1.6033));
            	String aa = String.format("%.2f", a);
            	Float aaa = Float.valueOf(aa);

            	Double b = Double.valueOf((aaa+115.16));
            	String bb = String.format("%.2f", b);
            	Float bbb = Float.valueOf(bb);	           	       	
            	                               
                Double f = Double.valueOf((x*58.96)/100);
                String ff = String.format("%.2f", f);
                Float fff = Float.valueOf(ff);

                Double g = Double.valueOf(((bbb+fff)*7)/100);
                String gg = String.format("%.2f", g);
                Float ggg = Float.valueOf(gg);

                Double h = Double.valueOf(aaa+fff+ggg+115.16);
                String hh = String.format("%.2f", h);
                Float hhh = Float.valueOf(hh);

            	$('#b1').val(aaa)
            	$('#b2').val(0)           	
				$('#all').val(aaa)
                $('#service').val(115.16)

                $('#sum').val(bbb)

                $('#ftd').val(fff)
                $('#vat').val(ggg)
                $('#sumall').val(hhh)

            }else{


            }


            })
       
        $('#cal2').on('click',{

        		$('#use').val("0")
        		$('#b1').val("")
        		$('#b2').val("")        		
        		$('#all').val("")
        		$('#service').val("")
        		$('#sum').val("")
                $('#ftd').val("")
                $('#vat').val("")
                $('#sumall').val("")




        })
    }
}
