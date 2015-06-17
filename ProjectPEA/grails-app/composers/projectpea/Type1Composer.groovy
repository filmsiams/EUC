package projectpea


class Type1Composer extends zk.grails.Composer {

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
        	if(x <= 50){                  
        		$('#b1').val("0")
        		$('#b2').val("0")
        		$('#b3').val("0")
        		$('#b4').val("0")
        		$('#b5').val("0")
        		$('#b6').val("0")
        		$('#b7').val("0")
        		$('#all').val("0")
        		$('#service').val("0")
        		$('#sum').val("0")      		
        	}else if(x > 15){
                Float a = Float.valueOf(15*1.8632);            
                String a1 = String.format("%.2f", a);
                Float a2 = Float.valueOf(a1);                
        		$('#b1').val(a2)

        	 		if(x > 25){
                        Float b = Float.valueOf(10*2.5026);            
                        String b1 = String.format("%.2f", b);
                        Float b2 = Float.valueOf(b1);
        				$('#b2').val(b2)

        				if(x > 35){
                            Float c = Float.valueOf(10*2.7549);            
                            String c1 = String.format("%.2f", c);
                            Float c2 = Float.valueOf(c1);
        					$('#b3').val(c2)

		        			if(x >= 36){
                                Float d = Float.valueOf((x-15-10-10)*3.1381);            
                                String d1 = String.format("%.2f", d);
                                Float d2 = Float.valueOf(d1);
		        				$('#b4').val(d2)

                                String al = String.format("%.2f", a2+b2+c2+d2);
                                Float al1 = Float.valueOf(al);                                
                                $('#all').val(al1)

                                if(x >= 101){ 
                                    Float e = Float.valueOf(((x-15-10-10)-(x-15-10-10-65))*3.1381);            
                                    String e1 = String.format("%.2f", e);
                                    Float e2 = Float.valueOf(e1);

                                    Float f = Float.valueOf((x-15-10-10-65)*3.2315);            
                                    String f1 = String.format("%.3f", f);
                                    Float f2 = Float.valueOf(f1);

                                    $('#b4').val(e2)                                                                   
                                    $('#b5').val(f2)
                                    
                                    String all = String.format("%.2f", a2+b2+c2+e2+f2);
                                    Float all1 = Float.valueOf(all);
                                    $('#all').val(all1)

                                    if(x >= 151){
                                        Float g = Float.valueOf(((x-15-10-10-65)-(x-15-10-10-65-50))*3.2315);            
                                        String g1 = String.format("%.2f", g);
                                        Float g2 = Float.valueOf(g1);

                                        Float h = Float.valueOf((x-15-10-10-65-50)*3.7362);            
                                        String h1 = String.format("%.2f", h);
                                        Float h2 = Float.valueOf(h1);

                                        $('#b5').val(g1)                                                                     
                                        $('#b6').val(h2)

                                        String alll = String.format("%.2f", a2+b2+c2+e2+g2+h2);
                                        Float all2 = Float.valueOf(alll);
                                        $('#all').val(all2)

                                        if(x > 400){
                                            Float i = Float.valueOf(((x-15-10-10-65-50)-(x-15-10-10-65-50-250))*3.7362);            
                                            String i1 = String.format("%.2f", i);
                                            Float i2 = Float.valueOf(i1);

                                            Float j = Float.valueOf((x-15-10-10-65-50-250)*3.9361);            
                                            String j1 = String.format("%.2f", j);
                                            Float j2 = Float.valueOf(j1);

                                            $('#b6').val(i2)                                                                     
                                            $('#b7').val(j2)

                                            String allll = String.format("%.2f", a2+b2+c2+e2+g2+i2+j2);
                                            Float all3 = Float.valueOf(allll);
                                            $('#all').val(all3)
                                        
                                        }
                                    }       
		        				}
		        			}
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
                $('#service').val("8.19")
                Float k = Float.valueOf($('#all').val());

                $('#sum').val(k+8.19)
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
        		$('#b4').val("")
        		$('#b5').val("")
        		$('#b6').val("")
        		$('#b7').val("")
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
                        add.type = "1.1"
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
                        add.type = "1.1"
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
