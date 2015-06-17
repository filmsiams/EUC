package projectpea


class AdminComposer extends zk.grails.Composer {

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

		int countlist = 1	
		for(Employee e : Employee.findAll()){
			
			$('#listuser > rows').append{
				row{
					label(value:"${countlist}")
					label(value:e.emid)
					label(value:e.nameem)
					label(value:e.position)
					label(value:e.claim)					
					button(id:e.id,image:"/ext/images/img/edit.png")
				}				
		}
	    countlist++
		    $('#listuser > rows > row > button').on('click',{
		    	def edit = Employee.findById(it.target.id)
		    	if(edit != null){

		    		edit.cedit = "1"
		    		session.cedit = edit.cedit
		    		edit.save()
		    		
		    		redirect(uri: "/userdata.zul")
	    		}else{
	    			redirect(uri: "/admin.zul")
	    		}
	    	}
	  	)}	
    }          
}
