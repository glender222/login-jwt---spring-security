package com.example.demo;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.login.Entity.PermissionEntity;
import com.example.demo.login.Entity.RoleEntity;
import com.example.demo.login.Entity.RoleEnum;
import com.example.demo.login.Entity.UserEntity;
import com.example.demo.login.Repository.UserRepository;

@SpringBootApplication
public class PyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyApplication.class, args);
	}
@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /* Create PERMISSIONS */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

          

         RoleEntity roleAdmin = RoleEntity.builder()
		 .roleEnum(RoleEnum.ADMIN)
		 .permissionList(Set.of(createPermission,deletePermission,readPermission,updatePermission))
         .build();

		 RoleEntity roleDirector = RoleEntity.builder()
		 .roleEnum(RoleEnum.DIRECTOR)
		 .permissionList(Set.of(readPermission,updatePermission,createPermission,deletePermission))
         .build();

		 RoleEntity roleCoordinador = RoleEntity.builder()
		 .roleEnum(RoleEnum.COORDINADOR)
		 .permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
         .build();

		 RoleEntity roleTutor = RoleEntity.builder()
		 .roleEnum(RoleEnum.TUTOR)
		 .permissionList(Set.of(createPermission,deletePermission,readPermission,updatePermission))
         .build();

		 RoleEntity roleSecretaria = RoleEntity.builder()
		 .roleEnum(RoleEnum.SECRETARIA)
		 .permissionList(Set.of(createPermission,deletePermission,readPermission,updatePermission))
         .build();

		 RoleEntity rolePracticante = RoleEntity.builder()
		 .roleEnum(RoleEnum.Practicante)
		 .permissionList(Set.of(readPermission,updatePermission,deletePermission,createPermission))
         .build();
      

		 
            /* CREATE USERS */
            UserEntity userSantiago = UserEntity.builder()
                    .username("santiago")
                    .password("58cc6181518fbfb49da9c50db08ce31aa92feebaecc6c46a3a8084e87b50f037")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity userDaniel = UserEntity.builder()
                    .username("daniel")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDirector))
                    .build();

            UserEntity userAndrea = UserEntity.builder()
                    .username("andrea")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleCoordinador))
                    .build();

            UserEntity userAnyi = UserEntity.builder()
                    .username("anyi")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleTutor))
                    .build();


					
					UserEntity userMaria = UserEntity.builder()
                    .username("maria")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleSecretaria))
                    .build();

					UserEntity userLeroy = UserEntity.builder()
                    .username("leroy")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(rolePracticante))
                    .build();

					userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi,userMaria,userLeroy));
	  









		  

};
	}
}