package projectpea


class PaymentComposer extends zk.grails.Composer {

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

        
        $('#srh').val(session.pay)

        $('#sbn').on('click',{

            def chk = Paytype1.findByNouser($('#srh').val())
            
                if(chk != null){

                    $('#sbn').disabled("true")
                    $('#ssd').disabled("")

                }else{

                     alert("ไม่พบรายการที่ท่านค้นหาค่ะ")
                }
            
            for(Paytype1 h1 : Paytype1.findAll()){  

                if(h1.nouser == $('#srh').val()){               
               
            		$('#show > rows').append{			

    					row{												
    						label(value:h1.id+h1.nouser)
    						label(value:h1.nouser)
    						label(value:"ที่พักอาศัย")
    						label(value:h1.month)
    						if(h1.status == "ค้างชำระ"){
    							label(value:h1.status,style:"font-weight:bold;color:red")
    						}else{
    							label(value:h1.status,style:"font-weight:bold;color:green")
    						}
    						button(id:h1.billid,image:"/ext/images/img/edit.png")
    												
    					}						
    				}              					

    				$('#show > rows > row > button').on('click',{

                        def go = Paytype1.findByBillid(it.target.id) 

                        session.bill = go.billid                 

                            if(go != null){
                               redirect(uri: "/printbill.zul")
                            }else{
                                alert("ขออภัยค่ะรายการขัดข้อง")
                            }
    				})
                }
   		   }

        $('#srh').val("")               
        session.pay == ""            

        })

        $('#ssd').on('click',{

            $('#sbn').disabled("")
            $('#ssd').disabled("true")

            if($('#show > rows > row').collect() != null){

                $('#show > rows > row').detach()

            }else{

            }

        })
        
    }
}
