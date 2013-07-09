package ru.vrn.com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import org.hibernate.Session;

import ru.vrn.com.datamodel.User;
import ru.vrn.com.datamodel.utils.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		Timestamp startSynch = new Timestamp(System.currentTimeMillis());
		System.out.println("startSynch " + startSynch);
		/*
		 * Session session = HibernateSessionFactory.getSession();
		 * session.beginTransaction();
		 * 
		 * User user = new User(); user.setLogin("ivailov");
		 * user.setMail("ivaylov@rusap.vrn.ru"); String str =
		 * EncryptedProperties.encrypt("ivashka"); System.out.println("str " +
		 * str); user.setPassword(str);
		 * 
		 * User user1 = new User(); user1.setLogin("vlasov");
		 * user1.setMail("vve@rusap.vrn.ru");
		 * user1.setPassword(EncryptedProperties.encrypt("zlatovlas"));
		 * 
		 * User user2 = new User(); user2.setLogin("kuzmenko");
		 * user2.setMail("kuzmenko@rusap.vrn.ru");
		 * user2.setPassword(EncryptedProperties.encrypt("kuzmich")); //
		 * session.save(user); session.save(user1); session.save(user2);
		 * 
		 * session.getTransaction().commit();
		 */

		// md5(md5(password)+salt), ���
		// md5( md5(password)+substr(md5(password),0,10) )

		/*
		 * //md5 String password = "1234567";
		 * 
		 * MessageDigest md = null; try { md = MessageDigest.getInstance("MD5");
		 * } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		 * md.update(password.getBytes());
		 * 
		 * byte byteData[] = md.digest();
		 * 
		 * //convert the byte to hex format method 1 StringBuffer sb = new
		 * StringBuffer(); for (int i = 0; i < byteData.length; i++) {
		 * sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
		 * 16).substring(1)); }
		 * 
		 * System.out.println("Digest(in hex format):: " + sb.toString());
		 * 
		 * //convert the byte to hex format method 2 StringBuffer hexString =
		 * new StringBuffer(); for (int i=0;i<byteData.length;i++) { String
		 * hex=Integer.toHexString(0xff & byteData[i]); if(hex.length()==1)
		 * hexString.append('0'); hexString.append(hex); }
		 * System.out.println("Digest(in hex format):: " +
		 * hexString.toString());
		 */

		/*
		 * 
		 * Path path = Paths.get("Z:/test");
		 * 
		 * System.out.println(path.toString());
		 * 
		 * List<AclEntry> aclEntries = null;
		 * 
		 * AclFileAttributeView fileAttributeView =
		 * Files.getFileAttributeView(path, AclFileAttributeView.class);
		 * 
		 * try { aclEntries = fileAttributeView.getAcl();
		 * 
		 * for (AclEntry aclEntry : aclEntries) {
		 * System.out.println("****************************************");
		 * System.out.println("principal " + aclEntry.principal().getName());
		 * System.out.println("type " + aclEntry.type().toString());
		 * System.out.println("permissions " +
		 * aclEntry.permissions().toString()); System.out.println("flags " +
		 * aclEntry.flags().toString());
		 * 
		 * } } catch (IOException e1) { e1.printStackTrace(); }
		 * 
		 * 
		 * 
		 * FileOwnerAttributeView view = Files.getFileAttributeView(path,
		 * FileOwnerAttributeView.class);
		 * 
		 * 
		 * // PosixFileAttributeView fileAttributeView =
		 * Files.getPosixFilePermissions(path, );
		 * 
		 * try { UserPrincipal userPrincipal = view.getOwner();
		 * System.out.println("userPrincipal " + userPrincipal); } catch
		 * (IOException e) { e.printStackTrace(); }
		 * 
		 * 
		 * }
		 */
	}
}
