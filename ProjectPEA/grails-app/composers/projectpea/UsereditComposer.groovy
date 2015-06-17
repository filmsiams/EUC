package projectpea


class UsereditComposer extends zk.grails.Composer {

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

        if(session.user == "admin"){
        	redirect(uri: "/admin.zul")
        }else {



            def fd = Employee.findByEditin(session.editin)          
    		if(fd != null){

                $('#emid').val(fd.emid)
                $('#passold').val(fd.passwords)
                $('#nameem').val(fd.nameem) 
                $('#numpeople').val(fd.numpeople)
                $('#position').val(fd.position)
                $('#claim').val(fd.claim)
                $('#address').val(fd.address)
                $('#tel').val(fd.tel)

                }else{

                }    

        $('#submit').on('click',{
                if($('#pass').val() != $('#passold').val()){
                    $('#cpass').val("รหัสผ่านไม่ตรงกันค่ะ !")
                    alert("รหัสผ่านไม่ตรงกันค่ะ")                  
                }else  {          

             			def xd = Employee.findByEditin(session.editin) 
             			if(xd != null){ 
                            xd.emid =$('#emid').val()
                            xd.passwords =$('#pass2').val()
                            xd.nameem =$('#nameem').val()
                            xd.numpeople =$('#numpeople').val()

                            xd.position =$('#position').val()
                            xd.claim =$('#claim').val()

                            xd.address =$('#address').val()
                            xd.tel =$('#tel').val()
                            
                            xd.cedit = ""
                           	xd.editin = "in"
                            xd.save()

                            alert("บันทึกข้อมูลเรียบร้อยแล้วค่ะ")
                            redirect(uri: "/index.zul")
                        }
                        
                }                  
        })


            $('#cancel').on('click',{
                redirect(uri: "/index.zul")
            })



    	}
	}
}

