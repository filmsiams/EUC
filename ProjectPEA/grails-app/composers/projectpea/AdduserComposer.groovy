package projectpea


class AdduserComposer extends zk.grails.Composer {

    def afterCompose = { window ->
        
        Date date = new Date()       
        java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat()        
        tf.applyPattern("HH:mm:ss")

        $('#userlogin').val(session.user)
        def ckn = Logincheck.findByUser(session.user)
        if(ckn == null){
            alert("ท่านยังไม่ทำการ login ค่ะ")
            redirect(uri: "/login.zul")
        }else if(session.claim != "Admin"){
            alert("เฉพาะ Admin เท่านั้น")
            redirect(uri: "/index.zul")
        }else{

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

    		$('#submit').on('click',{
        		if($('#pass').val() != $('#pass2').val()){
					$('#cpass').val("รหัสผ่านไม่ตรงกันค่ะ !")
					$('#cpass2').val("รหัสผ่านไม่ตรงกันค่ะ !")
				}else {

					def id = Employee.findByEmid($('#emid').val())
					if(id == null){

							def add = new Employee()

							add.emid =$('#emid').val()
							add.passwords =$('#pass').val()
							add.nameem =$('#nameem').val()
							add.numpeople =$('#numpeople').val()

							add.position =$('#position').val()
							add.claim =$('#claim').text()

							add.address =$('#address').val()
							add.tel =$('#tel').val()
							add.cedit = ""
                            add.editin = ""
							add.save()

							alert("บันทึกข้อมูลเรียบร้อยแล้วค่ะ")
							redirect(uri: "/admin.zul")
						
						}else{

							$('#cid').val("รหัสนี้มีผู้ใช้แล้วค่ะ !")				
						}
				}
			})

    		$('#cancel').on('click',{
				redirect(uri: "/admin.zul")
			})

    	}
	}	

