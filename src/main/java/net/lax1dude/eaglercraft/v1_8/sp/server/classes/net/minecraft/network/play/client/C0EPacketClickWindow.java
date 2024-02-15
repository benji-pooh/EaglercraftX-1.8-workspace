package net.lax1dude.eaglercraft.v1_8.sp.server.classes.net.minecraft.network.play.client;

import java.io.IOException;
import net.lax1dude.eaglercraft.v1_8.sp.server.classes.net.minecraft.item.ItemStack;
import net.lax1dude.eaglercraft.v1_8.sp.server.classes.net.minecraft.network.Packet;
import net.lax1dude.eaglercraft.v1_8.sp.server.classes.net.minecraft.network.PacketBuffer;
import net.lax1dude.eaglercraft.v1_8.sp.server.classes.net.minecraft.network.play.INetHandlerPlayServer;

import static net.lax1dude.eaglercraft.v1_8.sp.server.classes.ContextUtil.__checkIntegratedContextValid;

/**+
 * This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source code.
 * 
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!"
 * Mod Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 * 
 * EaglercraftX 1.8 patch files (c) 2022-2024 lax1dude, ayunami2000. All Rights Reserved.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */
public class C0EPacketClickWindow implements Packet<INetHandlerPlayServer> {

	static {
		__checkIntegratedContextValid("net/minecraft/network/play/client/C0EPacketClickWindow");
	}

	private int windowId;
	private int slotId;
	private int usedButton;
	private short actionNumber;
	private ItemStack clickedItem;
	private int mode;

	public C0EPacketClickWindow() {
	}

	public C0EPacketClickWindow(int windowId, int slotId, int usedButton, int mode, ItemStack clickedItem,
			short actionNumber) {
		this.windowId = windowId;
		this.slotId = slotId;
		this.usedButton = usedButton;
		this.clickedItem = clickedItem != null ? clickedItem.copy() : null;
		this.actionNumber = actionNumber;
		this.mode = mode;
	}

	/**+
	 * Passes this Packet on to the NetHandler for processing.
	 */
	public void processPacket(INetHandlerPlayServer inethandlerplayserver) {
		inethandlerplayserver.processClickWindow(this);
	}

	/**+
	 * Reads the raw packet data from the data stream.
	 */
	public void readPacketData(PacketBuffer parPacketBuffer) throws IOException {
		this.windowId = parPacketBuffer.readByte();
		this.slotId = parPacketBuffer.readShort();
		this.usedButton = parPacketBuffer.readByte();
		this.actionNumber = parPacketBuffer.readShort();
		this.mode = parPacketBuffer.readByte();
		this.clickedItem = parPacketBuffer.readItemStackFromBuffer_server();
	}

	/**+
	 * Writes the raw packet data to the data stream.
	 */
	public void writePacketData(PacketBuffer parPacketBuffer) throws IOException {
		parPacketBuffer.writeByte(this.windowId);
		parPacketBuffer.writeShort(this.slotId);
		parPacketBuffer.writeByte(this.usedButton);
		parPacketBuffer.writeShort(this.actionNumber);
		parPacketBuffer.writeByte(this.mode);
		parPacketBuffer.writeItemStackToBuffer_server(this.clickedItem);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public int getSlotId() {
		return this.slotId;
	}

	public int getUsedButton() {
		return this.usedButton;
	}

	public short getActionNumber() {
		return this.actionNumber;
	}

	public ItemStack getClickedItem() {
		return this.clickedItem;
	}

	public int getMode() {
		return this.mode;
	}
}