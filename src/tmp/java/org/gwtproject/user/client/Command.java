package org.gwtproject.user.client;

import org.gwtproject.core.client.Scheduler;

public interface Command extends Scheduler.ScheduledCommand {
  void execute();
}
