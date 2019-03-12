package assets;

import amazon.AmazonBase;
import amazon.Pages.GlobalPages;
import amazon.Pages.MusicPages;
import amazon.Pages.SettingsPages;

public class Cleaner extends AmazonBase {

	public static void cleaner() {
		
		GlobalPages.OpenAccountAndLists();
		SettingsPages.OpenAddresses();
		SettingsPages.DeleteAddress();
		MusicPages.OpenMp3Cart();
		MusicPages.RemoveAllMp3();
//TASK:	Check if added mp3 bubble element exist, if not, nothing to clean + other cleaner optimization plan
		GlobalPages.OpenCart();
		GlobalPages.DeleteAllCartItems();
	}
}
