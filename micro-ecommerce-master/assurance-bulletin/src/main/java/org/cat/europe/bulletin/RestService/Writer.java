package org.cat.europe.bulletin.RestService;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.cat.europe.bulletin.Repository.ProfessionelRepository;
import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.cat.europe.bulletin.domain.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public class Writer {

	//@Autowired
	//private static  ProfessionelRepository professionel;

	public static void saveOfficeContents(MultipartFile file , ProfessionelRepository pro) throws IOException {
		

		try {

			Workbook offices = new XSSFWorkbook(file.getInputStream());

			System.out.println("Sheet Index :" + offices.getSheetIndex("Sheet1"));
			Sheet worksheet = offices.getSheetAt(0);
			Row entry;
			Integer noOfEntries = 1;
			// getLastRowNum and getPhysicalNumberOfRows showing false values
			// sometimes.
			while (worksheet.getRow(noOfEntries) != null) {
				noOfEntries++;
			}
			System.out.println(noOfEntries.toString());
			for (int rowIndex = 0; rowIndex < noOfEntries; rowIndex++) {
				entry = worksheet.getRow(rowIndex);
				ProfessionelDeSante so = new ProfessionelDeSante();

				String nom = entry.getCell(0).getStringCellValue();
				so.setNom(nom);

				String adresse = entry.getCell(1).getStringCellValue();
				so.setAdresse(adresse);

				String email = entry.getCell(2).getStringCellValue();
				so.setEmail(email);

				double montant = entry.getCell(3).getNumericCellValue();
				so.setMontant(montant);

				int tel = (int) entry.getCell(4).getNumericCellValue();
				so.setTel(tel);

				String spec = entry.getCell(5).getStringCellValue();
				Specialite specialite = Specialite.valueOf(spec);
				so.setSpecialite(specialite);

				System.out.println("Row Contents:" + nom + " " + adresse + " " + email + " " + montant + " " + tel + " "
						+ specialite);
				
				if (pro == null ) {
					
					System.out.println("test null ");
				}
				pro.save(so);

				

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + " " + e.getCause());
			throw new MultipartException("Constraints Violated");
		}
	}

	public static void validateOfficeData(MultipartFile file) {

	}
}
