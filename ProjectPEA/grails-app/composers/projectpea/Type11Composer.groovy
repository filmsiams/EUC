package projectpea


class Type11Composer extends zk.grails.Composer {

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
        
        $('#cal1').src("ext/images/img/cal-1.png")
		$('#cal2').src("ext/images/img/cal-2.png")

       $('#1').on('click',{
            redirect(uri: "/type1.zul")
        })
       $('#2').on('click',{
            redirect(uri: "/type1-1.zul")
        })
       $('#3').on('click',{
            redirect(uri: "/type1-2.zul")
        })

        $('#cal1').on('click',{
            int v = Integer.parseInt($('#in').val()); 
            int w = Integer.parseInt($('#out').val());

            $('#use').val((v-w)*(-1))

            int x = Integer.parseInt($('#use').val());   	
        	if(x <= 0){

        		$('#b1').val("0")
        		$('#b2').val("0")
        		$('#b3').val("0")        		
        		$('#all').val("0")
        		$('#service').val("0")
        		$('#sum').val("0")

        	}else if(x >= 1){
                Float a = Float.valueOf(x*2.7628);            
                String a1 = String.format("%.2f", a);
                Float a2 = Float.valueOf(a1);                
        		$('#b1').val(a2)

                $('#all').val(a2)

        	 		if(x >= 151){
                        Float aa = Float.valueOf(150*2.7628);            
                        String aa1 = String.format("%.2f", aa);
                        Float aa2 = Float.valueOf(aa1);                
                        $('#b1').val(aa2)

                        Float b = Float.valueOf((x-150)*3.7362);            
                        String b1 = String.format("%.2f", b);
                        Float b2 = Float.valueOf(b1);
        				$('#b2').val(b2)

                        $('#all').val(aa2+b2)
                        Float ss = Float.valueOf($('#all').val());            
                        String sss = String.format("%.2f", ss);
                        Float ssss = Float.valueOf(sss);
                        $('#all').val(ssss)

        				if(x >= 401){
                            Float bb = Float.valueOf(250*3.7362);            
                            String bb1 = String.format("%.2f", bb);
                            Float bb2 = Float.valueOf(bb1);
                            $('#b2').val(bb2)

                            Float c = Float.valueOf((x-150-250)*3.9361);            
                            String c1 = String.format("%.2f", c);
                            Float c2 = Float.valueOf(c1);
        					$('#b3').val(c2)

                            $('#all').val(aa2+bb2+c2)
                            Float xx = Float.valueOf($('#all').val());            
                            String xxx = String.format("%.2f", xx);
                            Float xxxx = Float.valueOf(xxx);
                            $('#all').val(xxxx)

		        		}
                    }
                }


            if($('#all').val() == "0"){

                $('#service').val("0")                

                $('#sum').val("0")
                
                $('#ftd').val("0")
                              
                $('#vat').val("0")
                
                $('#sumall').val("0")

            }else{
                $('#service').val("38.22")

                Float k = Float.valueOf($('#all').val());
                $('#sum').val(k+38.22)
                Float l = Float.valueOf($('#sum').val());
                String m = String.format("%.2f", l);
                $('#sum').val(m)

                Float n = Float.valueOf($('#use').val());
                $('#ftd').val((n*58.96)/100)
                Float o = Float.valueOf($('#ftd').val());
                String p = String.format("%.2f", o);
                $('#ftd').val(p)
                        
                $('#vat').val(((l+o)*7)/100)
                Float q = Float.valueOf($('#vat').val());
                String r = String.format("%.2f", q);
                $('#vat').val(r)

                $('#sumall').val(l+o+q)
                Float s = Float.valueOf($('#sumall').val());
                String t = String.format("%.2f", s);
                $('#sumall').val(t)
            }


        })
       
        $('#cal2').on('click',{
        		$('#use').val("0")
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
        if(session.euc != null){
            $('#save').src("ext/images/img/save.png")
            $('#cancel').src("ext/images/img/cancel.png")

            }else{
            $('#save').src("")
            $('#cancel').src("")
            }

        $('#save').on('click',{

            if(session.euc == ""){

                alert("ท่านยังไม่เลือกรายการผู้ชำระไฟฟ้า ค่ะ!")

            }else{

            def check = Request.findByNouser(session.euc)
            def ido = Paytype1.findByNouser(session.euc)
            

                if(check.typeuse != "บ้านที่อยู่อาศัย" ){
                    alert("หมายเลขผู้ใช้ไฟฟ้าไม่ตรงกับประเภทใช้ไฟ ค่ะ!")

                }else if(ido == null){
                    def add = new Paytype1()

                        add.billid = "0"
                        add.nouser = session.euc
                        add.beforuse =$('#in').val()
                        add.afteruse =$('#out').val()
                        add.poweruse =$('#use').val()
                        add.type = "1.2"
                        add.press = "5"
                        add.onpeak ="-"
                        add.offpeak ="-"
                        add.paybase =$('#sum').val()
                        add.ftbase =$('#ftd').val()
                        add.vatbase =$('#vat').val()

                        Float dd = Float.valueOf($('#all').val());
                        Float bb = Float.valueOf($('#ftd').val());
                        Double ee = dd+bb;
                        String mm = String.format("%.2f", ee); 

                        add.sumall = mm

                        add.payall =$('#sumall').val()
                        add.month = df.format(date)
                        add.status = "ค้างชำระ"
                        add.save()

                    session.euc = ""
                    alert("บันทึกรายการเรียบร้อยค่ะ!")

                     
                    }else if(ido.month != df.format(date)){                    

                    def add = new Paytype1()

                        add.billid = "0"
                        add.nouser = session.euc
                        add.beforuse =$('#in').val()
                        add.afteruse =$('#out').val()
                        add.poweruse =$('#use').val()
                        add.type = "1.2"
                        add.press = "5"
                        add.onpeak ="-"
                        add.offpeak ="-"
                        add.paybase =$('#sum').val()
                        add.ftbase =$('#ftd').val()
                        add.vatbase =$('#vat').val()

                        Float dd = Float.valueOf($('#all').val());
                        Float bb = Float.valueOf($('#ftd').val());
                        Double ee = dd+bb;
                        String mm = String.format("%.2f", ee); 

                        add.sumall = mm

                        add.payall =$('#sumall').val()
                        add.month = df.format(date)
                        add.status = "ค้างชำระ"
                        add.save()

                    session.euc = ""
                    alert("บันทึกรายการเรียบร้อยค่ะ!")
                    
                }else {
                    alert("ผู้ใช้ไฟเดือนนี้แจ้งแล้วค่ะ!")
                }                       
            }
        })

        $('#cancel').on('click',{            

            

                def add = Paytype1.findByBillid("0")

                if(add != null){

                add.billid = add.id+add.nouser
                add.save()

                session.pay= add.nouser
                session.euc = ""
                session.billid = "" 

                redirect(uri: "/payment.zul")                

                }else{
                    alert("รายการผิดพลาดกลับไปเลือกรายการชำระใหม่ค่ะ")
                }
            
            
        })   


    }
}
