package projectpea


class Type21Composer extends zk.grails.Composer {

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
            redirect(uri: "/type1.zul")
        })
       $('#2').on('click',{
            redirect(uri: "/type1-1.zul")
        })       

        $('#cal1').on('click',{
            int x = Integer.parseInt($('#useon').val());
            int y = Integer.parseInt($('#useoff').val());

            if($('#volts').text() == "แรงดัน 12 - 24 กิโลโวลต์"){
	            Float ss = Float.valueOf((x*4.5827)+(y*2.1495));            
	            String sss = String.format("%.2f", ss);
	           	Float ssss = Float.valueOf(sss);
	            $('#all').val(ssss)
	            
	           	Float nn = Float.valueOf(312.24);
	            $('#service').val(nn)

	            Double mm = Double.valueOf(ssss+nn);
	            String mmm = String.format("%.2f", mm);
	            $('#sum').val(mmm)

	            Float oo = Float.valueOf(((x+y)*58.96)/100);
	            String ooo = String.format("%.2f", oo);
	            $('#ftd').val(ooo)

	            Double pp = Double.valueOf(((mm+oo)*7)/100);
	            String ppp = String.format("%.2f", pp);
	            $('#vat').val(ppp)

	            Double qq = Double.valueOf(mm+oo+pp);
	            String qqq = String.format("%.2f", qq);
	            $('#sumall').val(qqq)


            }else if($('#volts').text() == "แรงดันต่ำกว่า 12 กิโลโวลต์"){
            	Float ss = Float.valueOf((x*5.2674)+(y*2.1827));            
	            String sss = String.format("%.2f", ss);
	           	Float ssss = Float.valueOf(sss);
	            $('#all').val(ssss)

	            Float nn = Float.valueOf(46.16);
	            $('#service').val(nn)

	            Double mm = Double.valueOf(ssss+nn);
	            String mmm = String.format("%.2f", mm);
	            $('#sum').val(mmm)

	            Float oo = Float.valueOf(((x+y)*58.96)/100);
	            String ooo = String.format("%.2f", oo);
	            $('#ftd').val(ooo)

	            Double pp = Double.valueOf(((mm+oo)*7)/100);
	            String ppp = String.format("%.2f", pp);
	            $('#vat').val(ppp)

	            Double qq = Double.valueOf(mm+oo+pp);
	            String qqq = String.format("%.2f", qq);
	            $('#sumall').val(qqq)

            }else{
            	alert("ท่านยังไม่ได้เลือก รหัสแรงดันไฟฟ้า")
            }
       	
		})
        $('#cal2').on('click',{
            $('#useon').val("0")
            $('#useoff').val("0")
            $('#all').val("")
            $('#service').val("")
            $('#sum').val("")
            $('#ftd').val("")
            $('#vat').val("")
            $('#sumall').val("")

        })
	}
}
