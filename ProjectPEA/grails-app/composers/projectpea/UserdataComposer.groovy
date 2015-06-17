package projectpea


class UserdataComposer extends zk.grails.Composer {

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

    	def find = Employee.findByCedit(session.cedit)                      
    		if(find != null){

    			$('#emid').val(find.emid)
    			$('#pass').val(find.passwords)
    			$('#nameem').val(find.nameem)
    			$('#numpeople').val(find.numpeople)
    			$('#position').val(find.position)
    			
    			$('#address').val(find.address)
    			$('#tel').val(find.tel)

    		}else{
                redirect(uri: "/admin.zul")
                }
       

        $('#submit').on('click',{

                    def cedit = Employee.findByCedit(session.cedit)
                        if(cedit != null){                           

                            cedit.emid =$('#emid').val()
                            cedit.passwords =$('#pass2').val()
                            cedit.nameem =$('#nameem').val()
                            cedit.numpeople =$('#numpeople').val()

                            cedit.position =$('#position').val()
                            cedit.claim =$('#claim').text()

                            cedit.address =$('#address').val()
                            cedit.tel =$('#tel').val()
                            
                            cedit.cedit = ""
                            cedit.editin = ""
                            cedit.save()

                            alert("บันทึกข้อมูลเรียบร้อยแล้วค่ะ")
                            redirect(uri: "/admin.zul")
                        
                        }
                    
        })


            $('#cancel').on('click',{
                def dd = Employee.findByCedit(session.cedit)
                        if(dd != null){  
                            dd.cedit = ""
                            dd.save()
                            redirect(uri: "/admin.zul")
                        }
                
            })

    }
}
